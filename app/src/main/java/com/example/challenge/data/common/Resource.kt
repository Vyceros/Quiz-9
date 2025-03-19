package com.example.challenge.data.common

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

sealed class Resource<out D> {
    data class Success<out D>(val data: D) : Resource<D>()
    data class Error<out D>(val errorMessage: String) : Resource<D>()
    data class Loading<Nothing>(val loading: Boolean) : Resource<Nothing>()
}
