package com.tecsup.cafecampus.data.repository

import com.tecsup.cafecampus.data.local.CafeDatabase
import com.tecsup.cafecampus.data.local.entity.Producto
import com.tecsup.cafecampus.data.local.dao.ProductoDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class CafeRepositoryRoom(
    private val database: CafeDatabase
) : CafeRepository {

    override val productos: Flow<List<Producto>>
        get() = database.productoDao.getAll()

    override fun insertProducto(producto: Producto) = database.runTransaction {
        database.productoDao.insert(producto)
    }

    override fun updateProducto(producto: Producto) = database.runTransaction {
        database.productoDao.update(producto)
    }

    override fun deleteProducto(producto: Producto) = database.runTransaction {
        database.productoDao.delete(producto)
    }

    override fun getProductoById(id: Int): Producto? {
        return database.productoDao.getById(id).firstOrNull()
    }

    override val getProductosDisponibles: Flow<List<Producto>>
        get() = database.productoDao.getDisponibles()

    override val searchProductos: (String) -> Flow<List<Producto>>
        get { nombre ->
            database.productoDao.search(nombre)
        }
}

object CafeRepositoryFactory {
    fun create(database: CafeDatabase): CafeRepository {
        return CafeRepositoryRoom(database)
    }
}