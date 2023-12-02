package com.example.testtask1

import com.example.testtask1.model.PaymentsResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface PaymentApi {
    @GET("payments")
    suspend fun getListPayments(): PaymentsResponse
}