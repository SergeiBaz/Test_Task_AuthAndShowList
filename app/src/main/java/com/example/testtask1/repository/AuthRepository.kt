package com.example.testtask1.repository

import com.example.testtask1.AuthApi
import com.example.testtask1.model.LoginResponse
import com.example.testtask1.model.User
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Retrofit
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val retrofit: Retrofit
) {
    private val authApi = retrofit.create(AuthApi::class.java)
    private val gson = Gson()

    private fun createRequestBody(model: Any): RequestBody {
        return gson.toJson(model).toRequestBody("application/json".toMediaTypeOrNull())
    }

    suspend fun logInUser(user: User): LoginResponse? {
        return authApi.logInUser(createRequestBody(user))
    }
}
