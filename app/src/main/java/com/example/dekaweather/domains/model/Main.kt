package com.example.dekaweather.domains.model

import com.google.gson.annotations.SerializedName

data class Main(
    @SerializedName("temp")
    val temp: Double? = null,
    @SerializedName("feels_like")
    val feelsLike: Double? = null,
    @SerializedName("temp_min")
    val tempMin: Double? = null,
    @SerializedName("temp_max")
    val tempMax: Double? = null,
    @SerializedName("pressure")
    val pressure: Double? = null,
    @SerializedName("humidity")
    val humidity: Double? = null
)
