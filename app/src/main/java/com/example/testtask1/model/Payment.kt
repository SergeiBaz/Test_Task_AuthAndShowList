package com.example.testtask1.model

import com.google.gson.annotations.SerializedName

data class Payment(
    @SerializedName("id") private val _id: Int?,
    @SerializedName("title") private val _title: String?,
    @SerializedName("amount") private val _amount: String?,
    @SerializedName("created") private val _created: String?
) {
    val id
        get() = _id ?: throw IllegalArgumentException("Нет id")
    val title: String
        get() {
            return if (_title.isNullOrBlank()) {
                "Без заголовка"
            } else {
                _title
            }
        }

    val amount: String
        get() {
            return if (_amount.isNullOrBlank()) {
                "В обработке"
            } else {
                _amount
            }
        }
    val created: String
        get() {
            return if (_created.isNullOrBlank()) {
                "**********"
            } else {
                _created
            }
        }
}
