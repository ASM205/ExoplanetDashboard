package com.example.exoplanetdashboard.data.repository

import com.example.exoplanetdashboard.data.network.AssetInterface
import com.example.exoplanetdashboard.data.network.ImageInterface
import com.example.exoplanetdashboard.model.Linkitems

class ImageRepository(
    private val info: ImageInterface,
    private val imglink : AssetInterface
) {
    suspend fun getImage ( category: String){
        val result = info.getImages(category, "image")
        val imgLink = result.collection.items.firstOrNull()?.links?.firstOrNull()?.href
    }
}