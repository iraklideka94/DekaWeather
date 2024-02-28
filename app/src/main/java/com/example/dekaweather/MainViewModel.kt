package com.example.dekaweather

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dekaweather.data.remote.RetrofitClient
import com.example.dekaweather.domains.model.MyLatLang
import com.example.dekaweather.domains.model.WeatherResult
import com.example.dekaweather.domains.model.forecast.ForecastResult
import kotlinx.coroutines.launch

enum class STATE {
    LOADING,
    SUCCESS,
    ERROR
}

class MainViewModel: ViewModel() {

    var state by mutableStateOf(STATE.LOADING)
    var weatherResponse: WeatherResult by mutableStateOf(WeatherResult())
    var forecastResponse: ForecastResult by mutableStateOf(ForecastResult())
    var errorMessage by mutableStateOf("")


    fun getWeatherByLocation(latLng: MyLatLang){
        viewModelScope.launch {
            state = STATE.LOADING
            val apiService = RetrofitClient.getInstance()

            try {
                val apiResponse = apiService.getWeather(latLng.lat, latLng.lang)
                weatherResponse = apiResponse
                state = STATE.SUCCESS
            }catch (e:Exception){
                errorMessage = e.message!!.toString()
                state = STATE.ERROR
            }
        }
    }


    fun getForecastByLocation(latLng: MyLatLang){
        viewModelScope.launch {
            state = STATE.LOADING
            val apiService = RetrofitClient.getInstance()

            try {
                val apiResponse = apiService.getForecast(latLng.lat, latLng.lang)
                forecastResponse = apiResponse
                state = STATE.SUCCESS
            }catch (e:Exception){
                errorMessage = e.message!!.toString()
                state = STATE.ERROR
            }
        }
    }
}