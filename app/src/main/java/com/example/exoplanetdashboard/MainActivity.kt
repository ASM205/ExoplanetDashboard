package com.example.exoplanetdashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.ViewModelProvider
import com.example.exoplanetdashboard.ui.theme.ExoplanetDashboardTheme
import com.example.exoplanetdashboard.navigation.AppNavigation
import com.example.exoplanetdashboard.data.network.ImageClient
import com.example.exoplanetdashboard.data.repository.ImageRepository
import com.example.exoplanetdashboard.ui.viewmodel.ImageViewModel
import com.example.exoplanetdashboard.ui.viewmodel.ImageViewModelFactory

data class Navbar(
    val route: String,
    val label: String,
    val icon: Int
)

val navbar = listOf(
    Navbar("home", "Home", R.drawable.home_24dp_e3e3e3_fill0_wght400_grad0_opsz24),
    Navbar("exoplanets", "Exoplanets", R.drawable.planet_24dp_e3e3e3_fill0_wght400_grad0_opsz24),
    Navbar("nebula", "Nebula", R.drawable.icons8_nebula_48),
    Navbar("galaxy", "Galaxy", R.drawable.icons8_galaxy_50),
    Navbar("systems", "SolarSystems", R.drawable.solar_system)
)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Repository setup
        val imageRepo = ImageRepository(
            info = ImageClient.searchService
        )

        // ViewModel with factory (FIXED)
        val ivm: ImageViewModel = ViewModelProvider(
            this,
            ImageViewModelFactory(imageRepo)
        )[ImageViewModel::class.java]

        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()

            ExoplanetDashboardTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { Nav(navController, ivm) }
                ) { innerPadding ->
                    AppNavigation(
                        navController = navController,
                        viewModel = ivm,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Nav(navController: NavController, ivm: ImageViewModel) {
    NavigationBar {
        navbar.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.label,
                        modifier = Modifier.size(24.dp)
                    )
                },
                selected = false,
                onClick = {
                    ivm.fetchImages(item.label)
                    navController.navigate(item.route)
                }
            )
        }
    }
}