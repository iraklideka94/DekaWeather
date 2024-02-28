package com.example.dekaweather.domains.model.forecast

import com.example.dekaweather.domains.model.Clouds
import com.example.dekaweather.domains.model.Main
import com.example.dekaweather.domains.model.Sys
import com.example.dekaweather.domains.model.Weather
import com.example.dekaweather.domains.model.Wind
import com.google.gson.annotations.SerializedName

data class CustomList(
    @SerializedName("dt")
    val dt: Int? = null,
    @SerializedName("main")
    val main: Main? = Main(),
    @SerializedName("weather")
    val weather: ArrayList<Weather>? = arrayListOf(),
    @SerializedName("clouds")
    val clouds: Clouds? = Clouds(),
    @SerializedName("wind")
    val wind: Wind? = Wind(),
    @SerializedName("visibility")
    val visibility: Int? = null,
    @SerializedName("pop")
    val pop: Double? = null,
    @SerializedName("sys")
    val sys: Sys? = Sys(),
    @SerializedName("dt_txt")
    val dtTxt: String? = null
)
