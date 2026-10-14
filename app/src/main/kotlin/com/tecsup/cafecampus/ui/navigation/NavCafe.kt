package com.tecsup.cafecampus.ui.navigation

import com.tecsup.cafecampus.ui.cliente.SplashScreen
import com.tecsup.cafecampus.ui.cliente.MenuScreen
import com.tecsup.cafecampus.ui.cliente.SeguimientoScreen
import com.tecsup.cafecampus.ui.cliente.PerfilScreen
import com.tecsup.cafecampus.ui.admin.PanelAdminScreen
import com.tecsup.cafecampus.ui.admin.PedidosAdminScreen
import com.tecsup.cafecampus.ui.admin.MenuAdminScreen
import com.tecsup.cafecampus.ui.admin.AjustesScreen
import androidx.compose.navigation.compose.NavHost
import androidx.compose.navigation.compose.composable
import androidx.compose.navigation.compose.rememberNavController
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.BottomNavigation
import androidx.compose.material3.BottomNavigationItem
import androidx.compose.scope.requireActivity
import androidx.activity.compose.getNavController

@Composable
fun NavCafe(
    navController: androidx.compose.navigation.NavHostController = rememberNavController(),
    perfil: RoleProvider = RoleProvider(),
    content: @Composable () -> Unit
) {
    Scaffold(
        bottomBar = {
            BottomNavigation {
                // Cliente navigation
                BottomNavigationItem(
                    label = { Text("Menú") },
                    selected = navController.currentDestination?.route == Rutas.menu,
                    onClick = { navController.navigate(Rutas.menu) }
                )
                BottomNavigationItem(
                    label = { Text("Pedidos") },
                    selected = navController.currentDestination?.route == Rutas.pedidos,
                    onClick = { navController.navigate(Rutas.pedidos) }
                )
                BottomNavigationItem(
                    label = { Text("Perfil") },
                    selected = navController.currentDestination?.route == Rutas.perfil,
                    onClick = { navController.navigate(Rutas.perfil) }
                )

                // Admin items would be added based on perfil
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = Rutas.splash,
            expanded = false
        ) {
            composable(Rutas.splash) { SplashScreen(navController = navController) }
            composable(Rutas.menu) { MenuScreen(navController = navController) }
            composable(Rutas.pedidos) { 
                SeguimientoScreen(navController = navController) 
            }
            composable(Rutas.perfil) { PerfilScreen(navController = navController) }
            composable(Rutas.panel) { PanelAdminScreen(navController = navController) }
            composable(Rutas.pedidosAdmin) { PedidosAdminScreen(navController = navController) }
            composable(Rutas.menuAdmin) { MenuAdminScreen(navController = navController) }
            composable(Rutas.ajustes) { AjustesScreen(navController = navController) }
        }
    }
}

// Placeholder for role provider - will be integrated with DataStore later
object RoleProvider {
    var rol by remember { mutableStateOf(Rol.ESTUDIANTE) }
}