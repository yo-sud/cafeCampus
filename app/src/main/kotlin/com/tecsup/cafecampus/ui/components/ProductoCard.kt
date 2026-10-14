package com.tecsup.cafecampus.ui.components

import com.tecsup.cafecampus.data.local.entity.Producto
import com.tecsup.cafecampus.model.Rol
import com.tecsup.cafecampus.ui.theme.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui Unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.painter.painterResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ProductoCard(
    producto: Producto,
    navController: androidx.compose.navigation.NavController,
    showStock: Boolean = true
) {
    Card(
        modifier = Modifier
            .fillWidth()
            .padding(4.dp),
        elevation = 2.dp,
        colors = CardDefaults.cardColors(
            containerColor = Color.naranjaClaro
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            // Imagen del producto
            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = producto.nombre,
                modifier = Modifier
                    .size(80.dp)
                    .align(Alignment.CenterHorizontally)
            )

            // Nombre
            Text(
                text = producto.nombre,
                fontSize = 14.dp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                alignment = Alignment.CenterHorizontally
            )

            // Precio
            Text(
                text = "$${producto.precio}",
                fontSize = 12.dp,
                color = Color.naranjaPrimario,
                alignment = Alignment.CenterHorizontally
            )

            // Disponibilidad
            if (producto.disponible) {
                Chip(
                    text = { Text("Disponible") },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            } else {
                Chip(
                    text = { Text("Agotado") },
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    backgroundColor = Color.rojoEstado
                )
            }

            // Botón de agregar al carrito
            androidx.compose.foundation.Button(
                onClick = { /* TODO: Agregar al carrito */ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.naranjaPrimario,
                    contentColor = Color(0xFFFFFFFF)
                )
            ) {
                Text(
                    text = "Agregar al carrito",
                    fontSize = 10.dp,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                )
            }
        }
    }
}