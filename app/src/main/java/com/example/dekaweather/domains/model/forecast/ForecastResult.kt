package com.example.dekaweather.domains.model.forecast

import com.google.gson.annotations.SerializedName

data class ForecastResult(
    @SerializedName("cod")
    val cod: String? = null,
    @SerializedName("message")
    val message: Int? = null,
    @SerializedName("cnt")
    val cnt: Int? = null,
    @SerializedName("list")
    val list: ArrayList<CustomList>? = arrayListOf(),
    @SerializedName("city")
    val city: City? = null
)
