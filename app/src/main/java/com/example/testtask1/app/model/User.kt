package com.example.testtask1.app.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("login") private val _login: String?,
    @SerializedName("password") private val _password: String?,
)
