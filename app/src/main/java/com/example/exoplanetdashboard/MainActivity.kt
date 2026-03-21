package com.example.exoplanetdashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.exoplanetdashboard.ui.theme.ExoplanetDashboardTheme
import com.example.exoplanetdashboard.navigation.AppNavigation
import androidx.navigation.NavController
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Icon
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.size
import androidx.compose.ui.unit.dp



data class Navbar(
    val route: String,
    val label: String,
    val icon: Int
)

val navbar = listOf(
    Navbar("home", "Home", R.drawable.home_24dp_e3e3e3_fill0_wght400_grad0_opsz24),
    Navbar("exoplanets", "Exoplanets", R.drawable.planet_24dp_e3e3e3_fill0_wght400_grad0_opsz24) ,
    Navbar("nebula", "Nebula", R.drawable.icons8_nebula_48),
    Navbar("galaxy", "Galaxy", R.drawable.icons8_galaxy_50),
    Navbar("systems", "Systems", R.drawable.solar_system)

)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            ExoplanetDashboardTheme {
                    Scaffold(
                        bottomBar = { Nav(navController) },
                        modifier = Modifier.fillMaxSize()
                    ) { innerPadding -> AppNavigation(navController = navController, modifier = Modifier.padding(innerPadding))}
            }
        }
    }
}

// different context

@Composable
fun Nav(navController: NavController) {

        NavigationBar{
            navbar.forEach { item ->
                NavigationBarItem(
                    icon = {  Icon(painter = painterResource(id = item.icon), contentDescription = (item.label), modifier = Modifier.size(24.dp) ) },
                    selected = false,
                    onClick = {}
                )}
        }
}

@Preview(showBackground = true)
@Composable
fun NavPreview() {
    ExoplanetDashboardTheme {
        Nav(navController = rememberNavController())
    }
}
