package com.tecsup.cafecampus.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp

@Composable
fun AppTopBar(
    titulo: String,
    mostrarRetroceso: Boolean = true,
    onRetroceso: (() -> Unit)? = null
) {
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = androidx.compose.ui.platform.LocalContext.materialThemeResources.colorScheme.primary,
        title = {
            Text(
                text = titulo,
                fontSize = 24.dp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                color = Color(0xFFFFFFFF)
            )
        },
        actions = {
            if (mostrarRetroceso && onRetroceso != null) {
                IconButton(
                    onClick = onRetroceso,
                    content = {
                        Icon(
                            imageVector = androidx.compose.ui.platform.VectorIcons.Back,
                            contentDescription = "Retroceso",
                            tint = Color(0xFFFFFFFF)
                        )
                    }
                )
            }
        }
    )
}