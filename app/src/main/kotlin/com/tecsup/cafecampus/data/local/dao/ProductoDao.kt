package com.tecsup.cafecampus.data.local.dao

import com.tecsup.cafecampus.data.local.entity.Producto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.suspendOperation

interface ProductoDao {
    @javax.inject.Inject
    fun insert(producto: Producto): kotlinx.coroutines.suspendOperation.Unit

    @javax.inject.Inject
    fun update(producto: Producto): kotlinx.coroutines.suspendOperation.Unit

    @javax.inject.Inject
    fun delete(producto: Producto): kotlinx.coroutines.suspendOperation.Unit

    @javax.inject.Inject
    fun getAll(): Flow<List<Producto>>

    @javax.inject.Inject
    fun getById(id: Int): Producto?

    @javax.inject.Inject
    fun getDisponibles(): Flow<List<Producto>>

    @javax.inject.Inject
    fun search(nombre: String): Flow<List<Producto>>
}