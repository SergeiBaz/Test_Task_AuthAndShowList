package com.example.testtask1.model

import com.google.gson.annotations.SerializedName

data class Payment(
    @SerializedName("id") private val _id: Int?,
    @SerializedName("title") private val _title: String?,
    @SerializedName("amount") val _amount: String?,
    @SerializedName("created") val _created: String?
) {
    val id
        get() = _id ?: throw IllegalArgumentException("Нет id")
    val title
        get() = _title ?: "Без заголовка"
    val amount
        get() = _amount ?: "В обработке"
    val created
        get() = _created ?: "**********"
}
