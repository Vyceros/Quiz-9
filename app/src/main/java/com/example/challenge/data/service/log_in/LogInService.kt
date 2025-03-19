package com.example.challenge.data.service.log_in

import com.example.challenge.data.model.log_in.LogInDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LogInService {
    @FormUrlEncoded
    @POST("9e7e33ad-7152-45c2-8fbb-8940f9969ace")
    suspend fun logIn(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<LogInDto>
}