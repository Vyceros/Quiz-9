package com.example.challenge.presentation.screen.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challenge.domain.usecase.datastore.GetTokenUseCase
import com.example.challenge.presentation.screen.log_in.LogInViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val getTokenUseCase: GetTokenUseCase) :
    ViewModel() {

    private val _uiEvent = Channel<SplashUiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()


    init {
        readSession()
    }

    private fun readSession() {
        viewModelScope.launch {
            getTokenUseCase().collect {
                if (it.isEmpty())
                    _uiEvent.send(SplashUiEvent.NavigateToLogin)
                else
                    _uiEvent.send(SplashUiEvent.NavigateToConnections)
            }
        }
    }


}