package com.example.testtask1.di

import com.example.testtask1.repository.AuthRepository
import com.example.testtask1.repository.PaymentRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ServiceComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(ServiceComponent::class)
@Module
class ServiceModule {
    @Provides
    @Singleton
    fun provideAuthRepository(retrofit: Retrofit): AuthRepository {
        return AuthRepository(retrofit)
    }

    @Provides
    @Singleton
    fun providePaymentRepository(retrofit: Retrofit): PaymentRepository {
        return PaymentRepository(retrofit)
    }

}
