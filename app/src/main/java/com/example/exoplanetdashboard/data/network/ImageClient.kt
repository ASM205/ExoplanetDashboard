package com.example.exoplanetdashboard.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
// If you are using the @Url or @Query annotations in this file (less likely)
import retrofit2.http.GET
import retrofit2.http.Url

object ImageClient { // Changed to 'object' so it's a Singleton
    private const val BASE_URL = "https://images-api.nasa.gov/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // Service for searching (Step 1)
    val searchService: ImageInterface by lazy {
        retrofit.create(ImageInterface::class.java)
    }

    // Service for getting the asset list (Step 2)
    val assetService: AssetInterface by lazy {
        retrofit.create(AssetInterface::class.java)
    }
}