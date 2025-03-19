package com.example.challenge.presentation.screen.splash

sealed class SplashUiEvent {
    data object NavigateToLogin : SplashUiEvent()
    data object NavigateToConnections : SplashUiEvent()
}