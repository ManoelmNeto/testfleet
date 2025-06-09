package com.example.fletmaxmobile.data.ui.Telas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.fletmaxmobile.R
import com.example.fletmaxmobile.data.ui.AppYellow
import com.example.fletmaxmobile.data.ui.DarkBlue
import com.example.fletmaxmobile.data.ui.getTextFieldColors
import com.example.fletmaxmobile.ui.ScreenRoutes
import com.example.fletmaxmobile.ui.viewmodel.LoginViewModel

@Composable
fun LoginScreen(navController: NavController) {
    val loginViewModel: LoginViewModel = viewModel()
    val email by loginViewModel.email.collectAsState()
    val password by loginViewModel.password.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBlue)
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.logo_f_max),
            contentDescription = "Logotipo",
            tint = AppYellow,
            modifier = Modifier.size(120.dp)
        )
        Spacer(Modifier.height(48.dp))

        Spacer(Modifier.height(16.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { loginViewModel.onEmailChanged(it) },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            colors = getTextFieldColors()
        )
        Spacer(Modifier.height(16.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { loginViewModel.onPasswordChanged(it) },
            label = { Text("Senha") },
            modifier = Modifier.fillMaxWidth(),
            colors = getTextFieldColors(),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(Modifier.height(24.dp))

        Button(
            onClick = {
                loginViewModel.login()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }

        TextButton(
            onClick = {
                navController.navigate(ScreenRoutes.PASSWORD_RECOVERY_SCREEN)
            }
        ) {
            Text("Esqueci senha")
        }

        TextButton(
            onClick = {
                navController.navigate(ScreenRoutes.REGISTRO_SCREEN)
            }
        ) {
            Text("Comece aqui!", color = AppYellow, fontWeight = FontWeight.Bold)
        }

        Spacer(Modifier.height(32.dp))
    }
}
