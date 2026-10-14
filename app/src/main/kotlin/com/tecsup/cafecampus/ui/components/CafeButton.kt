package com.tecsup.cafecampus.ui.components

import androidx.compose.foundation.Button
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color

object CafeButtonStyle {
    val primaria = ButtonStyle(
        backgroundColor = Color.naranjaPrimario,
        backgroundColorDisabled = Color.naranjaClaro,
        backgroundColorPressed = Color.naranjaPrimario.copy(0.9f),
        contentColor = Color(0xFFFFFFFF),
        contentColorDisabled = Color(0xFFFFFFFF).copy(0.5f)
    )

    val secundario = ButtonStyle(
        backgroundColor = Color(0xFFFFFFFF),
        backgroundColorPressed = Color.naranjaClaro,
        contentColor = Color.naranjaPrimario,
        contentColorDisabled = Color.GRAY
    )
}

fun CafeButton(
    onClick: () -> Unit,
    text: String,
    style: ButtonStyle = CafeButtonStyle.primaria,
    modifier: Modifier = Modifier
) = Button(
    onClick = onClick,
    modifier = modifier.copy(width = 200.dp),
    style = style
) {
    Text(
        text = text,
        fontSize = 14.dp,
        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
    )
}

fun CafeTextField(
    label: String,
    value: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) = OutlinedTextField(
    value = value,
    onValueChange = onValueChanged,
    label = { Text(label) },
    modifier = modifier
        .fillMaxWidth()
        .padding(vertical = 4.dp),
    enabled = enabled
)