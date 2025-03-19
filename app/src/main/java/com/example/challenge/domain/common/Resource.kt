package com.example.challenge.domain.common

sealed class Resource<out D> {
    data class Success<out D>(val data: D) : Resource<D>()
    data class Error<out D>(val errorMessage: String) : Resource<D>()
    data class Loading<Nothing>(val loading: Boolean) : Resource<Nothing>()
}
