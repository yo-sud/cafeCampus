package com.tecsup.cafecampus.ui.cliente

import com.tecsup.cafecampus.ui.theme.CafeTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHostController

@Composable
fun SplashScreen(navController: NavController) {
    CafeTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "CafeCampus",
                fontSize = 48.dp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            // Productos destacados en el splash
            Text(
                text = "Tu cafetería en el campus",
                fontSize = 20.dp,
                color = androidx.compose.ui.platform.LocalContext.current.materialThemeResources.colorScheme.secondary
            )

            androidx.compose.foundation.Button(
                onClick = { navController.navigate("menu") },
                modifier = Modifier.width(200.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = androidx.compose.ui.platform.LocalContext.materialThemeResources.colorScheme.primary,
                    contentColor = Color(0xFFFFFFFF)
                )
            ) {
                Text(
                    text = "Empezar",
                    fontSize = 16.dp,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                )
            }
        }
    }
}