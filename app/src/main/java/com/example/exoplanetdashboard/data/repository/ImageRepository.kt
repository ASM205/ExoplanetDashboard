package com.example.exoplanetdashboard.data.repository

import com.example.exoplanetdashboard.data.network.ImageInterface
import com.example.exoplanetdashboard.model.ImageUiModel

class ImageRepository(
    private val info: ImageInterface
) {

    suspend fun getImages(category: String): List<ImageUiModel> {
        val result = info.getImages(category, "image")

        return result.collection.items.mapNotNull { item ->

            val imageUrl = item.links.firstOrNull()?.href
            val data = item.data.firstOrNull()

            if (imageUrl != null && data != null) {
                ImageUiModel(
                    imageUrl = imageUrl,
                    title = data.title,
                    description = data.description
                )
            } else {
                null
            }
        }
    }
}