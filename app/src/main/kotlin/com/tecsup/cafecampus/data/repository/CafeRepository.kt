package com.tecsup.cafecampus.data.repository

import com.tecsup.cafecampus.data.local.entity.Producto
import kotlinx.coroutines.flow.Flow

interface CafeRepository {
    // Productos
    val productos: Flow<List<Producto>>
        get()

    fun insertProducto(producto: Producto)

    fun updateProducto(producto: Producto)

    fun deleteProducto(producto: Producto)

    fun getProductoById(id: Int): Producto?

    fun getProductosDisponibles: Flow<List<Producto>>

    fun searchProductos(nombre: String): Flow<List<Producto>>

    // TODO: Agregar métodos de Usuario, Pedido y DetallePedido cuando se implementen
}