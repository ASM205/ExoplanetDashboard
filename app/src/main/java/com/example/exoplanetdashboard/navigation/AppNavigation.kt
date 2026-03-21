package com.example.exoplanetdashboard.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.ui.Modifier
import com.example.exoplanetdashboard.screens.Home
import com.example.exoplanetdashboard.screens.Exoplanets
import com.example.exoplanetdashboard.screens.Galaxy
import com.example.exoplanetdashboard.screens.Nebula
import com.example.exoplanetdashboard.screens.Systems
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController



@Composable
fun AppNavigation(modifier: Modifier = Modifier, navController : NavHostController) {
    //val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { Home() }
        composable("exoplanets") { Exoplanets() }
        composable("nebula") { Nebula() }
        composable("systems") { Systems() }
        composable("galaxy") { Galaxy() }
    }
}

