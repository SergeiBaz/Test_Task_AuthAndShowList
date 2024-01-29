package com.example.testtask1.app.di

import com.example.testtask1.app.model.TokenStorage
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class TokenInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.request()
            .addTokenHeader()
            .let { chain.proceed(it) }
    }

    private fun Request.addTokenHeader(): Request {
        return newBuilder()
            .apply {
                addHeader("app-key", ConstantsNetwork.HEADER_APP_KEY)
                addHeader("v", ConstantsNetwork.HEADER_V)
                val token = TokenStorage.token
                header("token", token ?: "")
            }
            .build()
    }
}