package com.example.challenge.presentation.screen.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challenge.domain.usecase.datastore.GetTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val getTokenUseCase: GetTokenUseCase) :
    ViewModel() {

    private val _uiEvent = MutableSharedFlow<SplashUiEvent>()
    val uiEvent = _uiEvent.asSharedFlow()


    init {
        readSession()
    }


    private fun readSession() {
        viewModelScope.launch(Dispatchers.IO) {
            getTokenUseCase().collect {
                if (it.isEmpty())
                    _uiEvent.emit(SplashUiEvent.NavigateToLogin)
                else
                    _uiEvent.emit(SplashUiEvent.NavigateToConnections)
            }
        }
    }


}