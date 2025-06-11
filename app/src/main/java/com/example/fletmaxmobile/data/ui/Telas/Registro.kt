package com.example.fletmaxmobile.data.ui.Telas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.fletmaxmobile.data.model.auth.RegisterRequest
import com.example.fletmaxmobile.data.ui.AppYellow
import com.example.fletmaxmobile.data.ui.DarkBlue
import com.example.fletmaxmobile.data.ui.TextGray
import com.example.fletmaxmobile.data.ui.viewmodel.RegisterViewModel

@Composable
fun RegistreScreen(
    navController: NavController,
    viewModel: RegisterViewModel = viewModel()
) {
    // State do ViewModel
    val isLoading by viewModel.isLoading.collectAsState()
    val success by viewModel.success.collectAsState()
    val error by viewModel.error.collectAsState()

    // Estados do formulário
    var cnpj by remember { mutableStateOf("") }
    var razaoSocial by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    // Se registro deu certo, navega para login
    LaunchedEffect(success) {
        if (success) {
            viewModel.clearState()
            navController.navigate("login") {
                popUpTo("registro") { inclusive = true }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBlue)
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // ... (todos os campos e botões que você já tem)

        if (isLoading) {
            Text("Registrando...", color = AppYellow)
        }

        if (error != null) {
            Text("Erro: $error", color = Color.Red)
        }

        Button(
            onClick = {
                if (password == confirmPassword) {
                    val request = RegisterRequest(
                        cnpj = cnpj,
                        razaoSocial = razaoSocial,
                        email = email,
                        password = password,
                        password_confirmation = confirmPassword
                    )
                    viewModel.register(request)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = AppYellow)
        ) {
            Text("Cadastrar", color = DarkBlue, fontWeight = FontWeight.Bold)
        }

        Spacer(Modifier.weight(1f))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Já tem conta na Filet Max?", color = TextGray)
            TextButton(onClick = {
                navController.navigate("login")
            }) {
                Text("Login", color = AppYellow, fontWeight = FontWeight.Bold)
            }
        }

        Spacer(Modifier.height(32.dp))
    }
}
