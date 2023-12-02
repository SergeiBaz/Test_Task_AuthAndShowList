package com.example.testtask1.di

import com.example.testtask1.model.TokenStorage
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
        val header1NameKey = "app-key"
        val header2NameV = "v"
        val authHeaderNameToken = "token"
        return newBuilder()
            .apply {
                addHeader(header1NameKey, ConstantsNetwork.HEADER1)
                addHeader(header2NameV, ConstantsNetwork.HEADER2)
                val token = TokenStorage.token
                if (token.isNotBlank()) {
                    header(authHeaderNameToken, token)
                }
            }
            .build()
    }
}