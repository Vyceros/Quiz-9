package com.example.challenge.presentation.screen.connection

import com.example.challenge.presentation.model.Connection

data class ConnectionState(
    val isLoading: Boolean = false,
    val connections: List<Connection> = emptyList(),
    val errorMessage: String? = null
)
