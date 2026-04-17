package com.example.exoplanetdashboard.screens

import androidx.compose.runtime.Composable
import com.example.exoplanetdashboard.ui.viewmodel.ImageViewModel

@Composable
fun Exoplanets(viewModel: ImageViewModel) {
    BaseScreen("Exoplanets", viewModel)
}