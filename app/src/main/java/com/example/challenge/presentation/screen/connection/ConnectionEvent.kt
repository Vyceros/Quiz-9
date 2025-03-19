package com.example.challenge.presentation.screen.connection

sealed class ConnectionEvent {
    data object FetchConnections : ConnectionEvent()
    data object LogOut : ConnectionEvent()
    data object ResetErrorMessage : ConnectionEvent()

}