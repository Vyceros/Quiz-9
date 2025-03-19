package com.example.challenge.presentation.model


data class Connection(
    val avatar: String,
    val email: String,
    val id: Int,
    val fullName: String,
    val isSelected: Boolean = false
)