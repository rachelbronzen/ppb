package com.example.resepkita

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.resepkita.ui.theme.ResepKitaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ResepKitaTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {

            composable("home") {
                HomeScreen(
                    onResepClick = { resepId ->
                        navController.navigate("detail/$resepId") },
                    onTambahResepClick = {
                        navController.navigate("tambah_resep")
                    }
                )
            }

            composable(
                route = "detail/{resepId}",
                arguments = listOf(navArgument("resepId") { type = NavType.IntType })
            ) { backStackEntry ->
                val id = backStackEntry.arguments?.getInt("resepId")
                val resepTerpilih = DataPalsu.daftarResep.find { it.id == id }
                if (resepTerpilih != null) {
                    DetailScreen(resep = resepTerpilih, onNavigateBack = { navController.popBackStack() } )
                }
            }

            composable("tambah_resep") {
                TambahResepScreen(
                    onSimpanSukses = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}
