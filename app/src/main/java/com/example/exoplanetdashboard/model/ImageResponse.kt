package com.example.exoplanetdashboard.model

data class ImageResponse(
    val collection: ImageCollection
)

data class ImageCollection(
    val items: List<ImageItem>
)

data class ImageItem(
    val data: List<DataItem>,
    val links: List<LinkItem>
)

data class DataItem(
    val title: String,
    val description: String? = null
)

data class LinkItem(
    val href: String
)