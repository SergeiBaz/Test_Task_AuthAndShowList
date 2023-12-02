package com.example.testtask1.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RetrofitModule {
    private lateinit var okhttpClient: OkHttpClient

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        init()
        return Retrofit.Builder()
            .baseUrl(ConstantsNetwork.URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okhttpClient)
            .build()
    }

    private fun init() {
        okhttpClient = OkHttpClient.Builder()
            .addNetworkInterceptor(TokenInterceptor())
            .build()
    }
}