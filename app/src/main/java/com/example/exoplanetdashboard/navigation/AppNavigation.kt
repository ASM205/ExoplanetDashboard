package com.example.exoplanetdashboard.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import com.example.exoplanetdashboard.screens.*
import com.example.exoplanetdashboard.ui.viewmodel.ImageViewModel

@Composable
fun AppNavigation(
    navController: NavHostController,
    viewModel: ImageViewModel,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier
    ) {

        composable("home") { Home(viewModel) }
        composable("exoplanets") { Exoplanets(viewModel) }
        composable("nebula") { Nebula(viewModel) }
        composable("galaxy") { Galaxy(viewModel) }
        composable("systems") { Systems(viewModel) }
    }
}