package com.example.challenge.presentation.screen.log_in

sealed class LogInEvent {
    data class LogIn(val email: String, val password: String) : LogInEvent()
    data object ResetErrorMessage : LogInEvent()
}