package com.tecsup.cafecampus.data.local

import com.tecsup.cafecampus.data.local.entity.Producto
import com.tecsup.cafecampus.data.local.CafeDatabase
import androidx.room.Room
import kotlinx.coroutines. runBlocking

object DatosIniciales {
    fun poblarDatos(db: CafeDatabase) {
        runBlocking {
            val productoDao = db.productoDao()

            // Verificar si ya hay productos para evitar duplicados
            val existentes = productoDao.getAll().firstOrNull()

            if (existentes.isNullOrEmpty()) {
                val productosIniciales = listOf(
                    Producto(
                        nombre = "Café Negro",
                        descripcion = "Café expreso puro y concentrado",
                        precio = 3.50,
                        categoria = "Bebidas",
                        urlImagen = "cafe_negro",
                        disponible = true
                    ),
                    Producto(
                        nombre = "Capuchino",
                        descripcion = "Café con leche espumada y cacao",
                        precio = 4.20,
                        categoria = "Bebidas",
                        urlImagen = "capuchino",
                        disponible = true
                    ),
                    Producto(
                        nombre = "Té Verde",
                        descripcion = "Infusión natural de té verde",
                        precio = 2.80,
                        categoria = "Bebidas",
                        urlImagen = "te_verde",
                        disponible = true
                    ),
                    Producto(
                        nombre = "Croissant",
                        descripcion = "Croissant fresco y crujiente",
                        precio = 2.50,
                        categoria = "Alimentos",
                        urlImagen = "croissant",
                        disponible = true
                    ),
                    Producto(
                        nombre = "Muffin de Vainilla",
                        descripcion = "Muffin dulce con vainilla",
                        precio = 3.00,
                        categoria = "Alimentos",
                        urlImagen = "muffin",
                        disponible = true
                    ),
                    Producto(
                        nombre = "Sándwich de Jamón",
                        descripcion = "Sándwich con jamón y queso",
                        precio = 5.00,
                        categoria = "Alimentos",
                        urlImagen = "sandwich",
                        disponible = true
                    )
                )

                for (producto in productosIniciales) {
                    productoDao.insert(producto)
                }
            }
        }
    }
}