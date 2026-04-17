package com.example.exoplanetdashboard.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.exoplanetdashboard.data.repository.ImageRepository
import com.example.exoplanetdashboard.model.ImageUiModel
import kotlinx.coroutines.launch

class ImageViewModel(
    private val repository: ImageRepository
) : ViewModel() {

    var images by mutableStateOf<List<ImageUiModel>>(emptyList())
        private set

    var error by mutableStateOf<String?>(null)
        private set

    fun fetchImages(query: String) {
        viewModelScope.launch {
            try {
                images = repository.getImages(query)
                error = null
            } catch (e: Exception) {
                images = emptyList()
                error = "Failed to load images"
            }
        }
    }
}

class ImageViewModelFactory(
    private val repository: ImageRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ImageViewModel(repository) as T
    }
}