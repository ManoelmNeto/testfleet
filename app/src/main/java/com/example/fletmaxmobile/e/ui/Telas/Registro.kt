package com.example.fletmaxmobile.e.ui.Telas

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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.fletmaxmobile.e.model.auth.RegisterRequest
import com.example.fletmaxmobile.e.ui.AppYellow
import com.example.fletmaxmobile.e.ui.DarkBlue
import com.example.fletmaxmobile.e.ui.TextGray
import com.example.fletmaxmobile.e.ui.getTextFieldColors
import com.example.fletmaxmobile.e.ui.viewmodel.RegisterViewModel
import com.example.fletmaxmobile.ui.ScreenRoutes

@Composable
fun RegistreScreen(
    navController: NavController,
    viewModel: RegisterViewModel = viewModel()
) {
    val isLoading by viewModel.isLoading.collectAsState()
    val success by viewModel.success.collectAsState()
    val error by viewModel.error.collectAsState()

    var cnpj by remember { mutableStateOf("") }
    var razaoSocial by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    LaunchedEffect(success) {
        if (success) {
            viewModel.clearState()
            navController.navigate(ScreenRoutes.LOGIN_SCREEN) {
                popUpTo(ScreenRoutes.REGISTRO_SCREEN) { inclusive = true }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBlue)
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Cadastro", color = AppYellow, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = cnpj,
            onValueChange = { cnpj = it },
            label = { Text("CNPJ") },
            modifier = Modifier.fillMaxWidth(),
            colors = getTextFieldColors()
        )

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = razaoSocial,
            onValueChange = { razaoSocial = it },
            label = { Text("Razão Social") },
            modifier = Modifier.fillMaxWidth(),
            colors = getTextFieldColors()
        )

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            colors = getTextFieldColors()
        )

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Senha") },
            modifier = Modifier.fillMaxWidth(),
            colors = getTextFieldColors(),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirmar Senha") },
            modifier = Modifier.fillMaxWidth(),
            colors = getTextFieldColors(),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(24.dp))

        if (isLoading) {
            Text("Registrando...", color = AppYellow)
        }

        error?.let {
            Text("Erro: $it", color = Color.Red)
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
                } else {
                    // Pode adicionar validação visual aqui também
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
                navController.navigate(ScreenRoutes.LOGIN_SCREEN)
            }) {
                Text("Login", color = AppYellow, fontWeight = FontWeight.Bold)
            }
        }

        Spacer(Modifier.height(32.dp))
    }
}