package com.example.exoplanetdashboard.data.network

import com.example.exoplanetdashboard.model.ImageResponse
import retrofit2.http.Query
import retrofit2.http.GET
import retrofit2.http.Url

interface ImageInterface {
    @GET("search")
    suspend fun getImages(
        @Query("q") searchTerm: String,      // "solar system" or "nebula"
        @Query("media_type") type: String    // Always "image" for you
    ): ImageResponse
}
interface AssetInterface {
    @GET
    suspend fun getAsses(
        @Url hrefUrl: String // This takes the full URL link found in Step 1
    ): List<String>
}