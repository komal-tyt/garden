package ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ui.screen.HomeScreen
import ui.screen.MainScreen
import ui.screen.SplashScreen
import ui.screen.RegistrationScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen(
                onTimeout = {
                    navController.navigate("reg_screen") {
                        popUpTo("splash") { inclusive = true }
                    }
                }
            )
        }

        composable("reg_screen") {
            RegistrationScreen(
                onClick = {
                    navController.navigate("main") {
                        popUpTo("reg_screen") { inclusive = true }
                    }
                }
            )
        }

        composable("main") {
            MainScreen()
        }
    }
}