package com.example.exoplanetdashboard.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.exoplanetdashboard.ui.viewmodel.ImageViewModel
import com.example.exoplanetdashboard.model.ImageUiModel


@Composable
fun ImageCard(item: ImageUiModel) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
    ) {

        AsyncImage(
            model = item.imageUrl,
            contentDescription = item.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = item.title)

        Spacer(modifier = Modifier.height(4.dp))

        Text(text = item.description ?: "")
    }
}
@Composable
fun BaseScreen(
    title: String,
    viewModel: ImageViewModel
) {

    val images = viewModel.images
    val error = viewModel.error

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = title)

        Spacer(modifier = Modifier.height(12.dp))

        if (error != null) {
            Text(text = error)
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(
                items = images,
                key = { it.imageUrl }
            ) { item ->
                ImageCard(item)
            }
        }
    }
}