package com.tecsup.cafecampus.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tecsup.cafecampus.data.local.entity.Producto

@Database(entities = [Producto::class], version = 1, exportSchema = false)
abstract class CafeDatabase : RoomDatabase() {
    abstract fun productoDao(): com.tecsup.cafecampus.data.local.dao.ProductoDao
}