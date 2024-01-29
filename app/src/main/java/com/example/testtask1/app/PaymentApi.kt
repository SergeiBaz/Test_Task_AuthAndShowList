package com.example.testtask1.app

import com.example.testtask1.app.model.PaymentsResponse
import retrofit2.http.GET

interface PaymentApi {
    @GET("payments")
    suspend fun getListPayments(): PaymentsResponse
}