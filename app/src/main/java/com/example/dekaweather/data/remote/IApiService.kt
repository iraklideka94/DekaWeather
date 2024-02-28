package com.example.dekaweather.data.remote

import androidx.compose.ui.unit.Constraints
import com.example.dekaweather.domains.model.WeatherResult
import com.example.dekaweather.domains.model.forecast.ForecastResult
import com.example.dekaweather.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiService {

    @GET("weather")
    suspend fun getWeather(
        @Query("lat") lat: Double = 0.0,
        @Query("lon") lng: Double = 0.0,
        @Query("units") units: String = "metric",
        @Query("appid") appid: String = Constants.API_KEY
    ): WeatherResult


    @GET("forecast")
    suspend fun getForecast(
        @Query("lat") lat: Double = 0.0,
        @Query("lon") lng: Double = 0.0,
        @Query("units") units: String = "metric",
        @Query("appid") appid: String = Constants.API_KEY
    ): ForecastResult


}