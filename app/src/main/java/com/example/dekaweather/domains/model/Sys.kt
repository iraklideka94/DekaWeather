package com.example.dekaweather.domains.model

import com.google.gson.annotations.SerializedName

data class Sys(
    @SerializedName("type")
    val type: Int? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("message")
    val message: Double? = null,
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("sunrise")
    val sunrise: Int? = null,
    @SerializedName("sunset")
    val sunset: Int? = null
)
