package com.example.testtask1.app.repository

import com.example.testtask1.app.PaymentApi
import com.example.testtask1.app.model.Payment
import retrofit2.Retrofit
import javax.inject.Inject

class PaymentRepository @Inject constructor(
    private val retrofit: Retrofit
) {
    private val paymentApi = retrofit.create(PaymentApi::class.java)

    suspend fun getListPayments(): List<Payment> {
        return paymentApi.getListPayments()._response
    }
}