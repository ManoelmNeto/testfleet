package com.example.fletmaxmobile.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fletmaxmobile.e.ui.Telas.CaminhaoScreen
import com.example.fletmaxmobile.e.ui.Telas.DashboardScreen
import com.example.fletmaxmobile.e.ui.Telas.LoginScreen
import com.example.fletmaxmobile.e.ui.Telas.MotoristaScreen
import com.example.fletmaxmobile.e.ui.Telas.PasswordRecoveryScreen
import com.example.fletmaxmobile.e.ui.Telas.RegistreScreen
import com.example.fletmaxmobile.e.ui.Telas.RotasScreen

object ScreenRoutes {
    const val LOGIN_SCREEN = "login"
    const val REGISTRO_SCREEN = "registro"
    const val PASSWORD_RECOVERY_SCREEN = "password_recovery"
    const val DASHBOARD_SCREEN = "dashboard"
    const val MOTORISTA_SCREEN = "motorista"
    const val CAMINHAO_SCREEN = "caminhao"
    const val ROTAS_SCREEN = "rotas"
}

@Composable
fun AppNavigationGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.LOGIN_SCREEN
    ) {
        composable(ScreenRoutes.LOGIN_SCREEN) {
            LoginScreen(navController = navController)
        }
        composable(ScreenRoutes.REGISTRO_SCREEN) {
            RegistreScreen(navController = navController)
        }
        composable(ScreenRoutes.PASSWORD_RECOVERY_SCREEN) {
            PasswordRecoveryScreen(navController = navController)
        }
        composable(ScreenRoutes.DASHBOARD_SCREEN) {
            DashboardScreen(navController = navController)
        }
        composable(ScreenRoutes.MOTORISTA_SCREEN) {
            MotoristaScreen(navController = navController)
        }
        composable(ScreenRoutes.CAMINHAO_SCREEN) {
            CaminhaoScreen(navController = navController)
        }
        composable(ScreenRoutes.ROTAS_SCREEN) {
            RotasScreen(navController = navController)
        }
    }
}
