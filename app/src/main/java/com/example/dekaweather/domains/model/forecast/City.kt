package com.example.dekaweather.domains.model.forecast

import com.example.dekaweather.domains.model.Coord
import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("coord")
    val coord: Coord? = null,
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("population")
    val population: Int? = null,
    @SerializedName("timezone")
    val timezone: Int? = null,
    @SerializedName("sunrise")
    val sunrise: Int? = null,
)
