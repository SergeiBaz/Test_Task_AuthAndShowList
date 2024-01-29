package com.example.testtask1.app.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("success") val _success: Boolean,
    @SerializedName("response") val _response: ResponseToken?,
    @SerializedName("error") val _error: ResponseError?,
)
