package com.example.testtask1.app

import com.example.testtask1.app.model.LoginResponse
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("login")
    suspend fun logInUser(@Body requestBody: RequestBody): LoginResponse?
}