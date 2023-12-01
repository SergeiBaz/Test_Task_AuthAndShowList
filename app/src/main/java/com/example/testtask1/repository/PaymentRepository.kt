package com.example.testtask1.repository

import com.example.testtask1.PaymentApi
import com.example.testtask1.model.Payment
import com.example.testtask1.model.Token
import retrofit2.Retrofit
import javax.inject.Inject

class PaymentRepository @Inject constructor(
    private val retrofit: Retrofit
) {
    private val paymentApi = retrofit.create(PaymentApi::class.java)

    suspend fun getListPayments(token: Token): List<Payment> {
        return paymentApi.getListPayments(token)
    }
}