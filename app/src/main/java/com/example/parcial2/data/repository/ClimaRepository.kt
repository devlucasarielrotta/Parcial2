package com.example.parcial2.data.repository

import com.example.parcial2.data.model.Clima
import com.example.parcial2.network.ApiService

class ClimaRepository(private val apiService: ApiService) {

    suspend fun getCurrentWeather(cityName: String, apiKey: String): Clima? {
        val response = apiService.getCurrentWeather(cityName, apiKey)
        if (response.isSuccessful) {
            return response.body()
        } else {
            return null
        }


    }
}
