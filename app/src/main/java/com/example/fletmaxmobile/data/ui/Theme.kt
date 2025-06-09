package com.example.fletmaxmobile.data.ui

import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.fletmaxmobile.R

// =================================================
// 1. DEFINIÇÃO DE CORES GLOBAIS
// =================================================
val DarkBlue = Color(0xFF1A232E)
val AppYellow = Color(0xFFF7A42C)
val LightGray = Color(0xFFF1F1F1)
val TextGray = Color(0xFFB0B0B0)
val DarkCard = Color(0xFF2C3A4A)
val SuccessGreen = Color(0xFF198754)
val ErrorRed = Color(0xFFDC3545)


// =================================================
// 2. PALETA DE CORES PERSONALIZADA (ESCURO)
// =================================================
private val AppDarkColorScheme = darkColorScheme(
    primary = AppYellow,
    onPrimary = DarkBlue,
    background = DarkBlue,
    surface = DarkCard,
    onBackground = Color.White,
    onSurface = Color.White
)


// =================================================
// 3. THEME COMPOSABLE REUTILIZÁVEL
// =================================================
@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = AppDarkColorScheme,
        typography = MaterialTheme.typography,
        content = content
    )
}


// =================================================
// 4. COMPONENTE REUTILIZÁVEL: BARRA SUPERIOR (TOOLBAR)
// =================================================
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppToolbar(onMenuClicked: () -> Unit) {
    TopAppBar(
        title = {
            Icon(
                painter = painterResource(id = R.drawable.logo_f_max),
                contentDescription = "Logotipo Fleet Max",
                tint = DarkBlue,
                modifier = Modifier.height(24.dp)
            )
        },
        navigationIcon = {
            IconButton(onClick = onMenuClicked) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.MenuBook,
                    contentDescription = "Menu",
                    tint = DarkBlue
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = AppYellow
        )
    )
}


// =================================================
// 5. FUNÇÃO AUXILIAR: CORES DOS CAMPOS DE TEXTO
// =================================================
@Composable
fun getTextFieldColors() = OutlinedTextFieldDefaults.colors(
    focusedBorderColor = AppYellow,
    unfocusedBorderColor = Color.Gray,
    focusedLabelColor = AppYellow,
    unfocusedLabelColor = Color.Gray,
    cursorColor = AppYellow,
    focusedTextColor = Color.White,
    unfocusedTextColor = Color.White,
)
