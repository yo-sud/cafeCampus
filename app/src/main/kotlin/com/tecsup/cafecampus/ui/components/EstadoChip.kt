package com.tecsup.cafecampus.ui.components

import com.tecsup.cafecampus.model.EstadoPedido
import androidx.compose.material3.Chip
import androidx.compose.ui.unit.dp

fun EstadoChip(
    estado: EstadoPedido,
    modifier: Modifier = Modifier
): Chip {
    val coloresEstado = when (estado) {
        EstadoPedido.RECIBIDO -> {
            val color = com.tecsup.cafecampus.ui.theme.Color.azulEstado
            ChipDefaults.chipColor(
                default = color,
                pressed = color.copy(0.8f),
                selected = color.copy(1.2f)
            )
        }
        EstadoPedido.PREPARANDO -> {
            val color = com.tecsup.cafecampus.ui.theme.Color.amarilloEstado
            ChipDefaults.chipColor(
                default = color,
                pressed = color.copy(0.8f),
                selected = color.copy(1.2f)
            )
        }
        EstadoPedido.LISTO -> {
            val color = com.tecsup.cafecampus.ui.theme.Color.verdeEstado
            ChipDefaults.chipColor(
                default = color,
                pressed = color.copy(0.8f),
                selected = color.copy(1.2f)
            )
        }
        EstadoPedido.ENTREGADO -> {
            val color = com.tecsup.cafecampus.ui.theme.Color.grisEstado
            ChipDefaults.chipColor(
                default = color,
                pressed = color.copy(0.8f),
                selected = color.copy(1.2f)
            )
        }
        EstadoPedido.CANCELADO -> {
            val color = com.tecsup.cafecampus.ui.theme.Color.rojoEstado
            ChipDefaults.chipColor(
                default = color,
                pressed = color.copy(0.8f),
                selected = color.copy(1.2f)
            )
        }
    }

    return Chip(
        text = { when (estado) {
            EstadoPedido.RECIBIDO -> Text("Recibido")
            EstadoPedido.PREPARANDO -> Text("Preparando")
            EstadoPedido.LISTO -> Text("Listo")
            EstadoPedido.ENTREGADO -> Text("Entregado")
            EstadoPedido.CANCELADO -> Text("Cancelado")
        } },
        modifier = modifier,
        backgroundColor = coloresEstado.default,
        clickable = true,
        onClick = { /* TODO: manejar clic */ }
    )
}