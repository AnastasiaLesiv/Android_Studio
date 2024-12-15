package com.example.lab_3.api

import retrofit2.http.GET

data class ApiResponse(
    val products: List<ItemApiModel> // Масив елементів знаходиться у полі "products"
)

interface ApiService {
    @GET("products")
    suspend fun getItems(): ApiResponse
}
