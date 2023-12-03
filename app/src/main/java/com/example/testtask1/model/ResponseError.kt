package com.example.testtask1.model

import com.google.gson.annotations.SerializedName

data class ResponseError(
    @SerializedName("error_code") val _errorCode: Int,
    @SerializedName("error_msg") val _errorMsg: String,
)
