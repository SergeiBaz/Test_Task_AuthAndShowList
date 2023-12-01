package com.example.testtask1.repository

import com.example.testtask1.PaymentApi
import com.example.testtask1.model.Payment
import retrofit2.Retrofit
import javax.inject.Inject

class PaymentRepository @Inject constructor(
    private val retrofit: Retrofit
) {
    private val paymentApi = retrofit.create(PaymentApi::class.java)

    suspend fun getListPayments(token: String): List<Payment> {
        return paymentApi.getListPayments(token)._response
    }
}