package com.example.challenge.data.mapper.base

import com.example.challenge.data.common.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


fun <DTO, DOMAIN> Flow<Resource<DTO>>.asResource(
    onSuccess: suspend (DTO) -> DOMAIN,
): Flow<Resource<DOMAIN>> {
    return this.map {
        when (it) {
            is Resource.Success -> Resource.Success(data = onSuccess(it.data))
            is Resource.Error -> Resource.Error(errorMessage = it.errorMessage)
            is Resource.Loading -> Resource.Loading(loading = it.loading)
        }
    }
}
