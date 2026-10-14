package com.tecsup.cafecampus.ui.cliente

import com.tecsup.cafecampus.data.local.entity.Producto
import com.tecsup.cafecampus.model.Rol
import com.tecsup.cafecampus.ui.theme.CafeTheme
import androidx.compose.foundation.grid.SpacingStrategy
import androidx.compose.foundation.grid.Row
import androidx.compose.foundation.grid.collectAsLazyGrid
import androidx.compose.foundation.relative.priority
import androidx.compose.foundation.relativelayout.RelativeLayout
import androidx.compose.foundation.size
import androidx.compose.foundation.verticallayout
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.PointerInput
import androidx.compose.ui.Unit.dp
import androidx.compose.ui.geometry.size
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.VectorPainter
import androidx.compose.ui.input.pointer.rememberPointerState
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.TextStyle
import androidx.compose.ui.unit.txt
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.compose.rememberViewModel
import androidx.paging.PagingSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import androidx.paging.rxjava2.Paging

@Composable
fun MenuScreen(navController: androidx.compose.navigation.NavController) {
    val viewModel = rememberViewModel<com.tecsup.cafecampus.viewmodel.MenuViewModel>()

    CafeTheme {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterStart
        ) {
            // Header
            AppTopBar(
                titulo = "Menú",
                mostrarRetroceso = false
            )

            // Filtrar productos disponibles
            var filtroPorCategoria by remember { mutableStateOf("") }

            // Lista de categorías
            Row(
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextButton(
                    onClick = { filtroPorCategoria = "" },
                    modifier = Modifier.width(100.dp),
                    enabled = filtroPorCategoria != "",
                    text = { Text("Todos") }
                )
                TextButton(
                    onClick = { filtroPorCategoria = "Bebidas" },
                    modifier = Modifier.width(100.dp),
                    enabled = filtroPorCategoria != "Bebidas",
                    text = { Text("Bebidas") }
                )
                TextButton(
                    onClick = { filtroPorCategoria = "Alimentos" },
                    modifier = Modifier.width(100.dp),
                    enabled = filtroPorCategoria != "Alimentos",
                    text = { Text("Alimentos") }
                )
            }

            // Grid de productos usando LazyColumn
            val productos = viewModel.productos.collectAsState().value ?: emptyList()

            if (productos.isEmpty()) {
                Text("Cargando productos...")
            } else {
                // Grid de 2 columnas
                var columnCount by remember { mutableStateOf(2) }

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = androidx.compose.ui.platform.Constants.spacingExtraSmall
                ) {
                    // Products in grid - 2 per row
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        // First row products
                        if (productos.isNotEmpty()) {
                           ProductoCard(producto = productos[0], navController = navController)
                        }
                        if (productos.size > 1) {
                            ProductoCard(producto = productos[1], navController = navController)
                        }
                    }

                    // Second row
                    if (productos.size > 2) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            if (productos.size > 3) {
                                ProductoCard(producto = productos[2], navController = navController)
                            }
                            if (productos.size > 3) {
                                ProductoCard(producto = productos[3], navController = navController)
                            }
                        }
                    }
                }
            }
        }
    }
}