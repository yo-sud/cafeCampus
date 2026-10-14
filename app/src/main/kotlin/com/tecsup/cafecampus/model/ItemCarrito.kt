package com.tecsup.cafecampus.model

data class ItemCarrito(
    val producto: com.tecsup.cafecampus.data.local.entity.Producto,
    val cantidad: Int = 1
)