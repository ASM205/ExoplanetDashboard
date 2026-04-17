package com.example.exoplanetdashboard.screens

import androidx.compose.runtime.Composable
import com.example.exoplanetdashboard.ui.viewmodel.ImageViewModel

@Composable
fun Galaxy(viewModel: ImageViewModel) {
    BaseScreen("Galaxy", viewModel)
}