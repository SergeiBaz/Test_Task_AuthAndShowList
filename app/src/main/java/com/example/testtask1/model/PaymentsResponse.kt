package com.example.testtask1.model

import com.google.gson.annotations.SerializedName

data class PaymentsResponse(
    @SerializedName("success") val _success: Boolean?,
    @SerializedName("response") val _response: List<Payment>,
)
