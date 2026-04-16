package com.example.exoplanetdashboard.model

data class ImageResponse(
    val collection : Imagecollection
)
data class Imagecollection(
    val items : List<ImageItems>
)

data class ImageItems(
    val data: List<Dataitems>,
    val links: List<Linkitems>
)
data class Dataitems(
    val desc: String,
    val title: String,
)
data class  Linkitems  (
    val href: List<String>
)