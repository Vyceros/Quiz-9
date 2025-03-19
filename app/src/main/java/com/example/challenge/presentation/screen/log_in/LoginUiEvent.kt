package com.example.challenge.presentation.screen.log_in

sealed class LoginUiEvent {
    data object NavigateToConnections : LoginUiEvent()
    data class ShowError(val message : String) : LoginUiEvent()
}
