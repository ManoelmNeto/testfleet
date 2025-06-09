package com.example.fletmaxmobile.data.ui.Telas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fletmaxmobile.R
import com.example.fletmaxmobile.data.ui.AppYellow
import com.example.fletmaxmobile.data.ui.DarkBlue
import com.example.fletmaxmobile.data.ui.getTextFieldColors
import com.example.fletmaxmobile.data.ui.viewmodel.PasswordRecoveryViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun PasswordRecoveryScreen(
    navController: NavController,
    viewModel: PasswordRecoveryViewModel = viewModel()
) {
    var emailOrCnpj by remember { mutableStateOf(TextFieldValue("")) }
    val isLoading by viewModel.isLoading.collectAsState()
    val success by viewModel.successMessage.collectAsState()
    val error by viewModel.errorMessage.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBlue)
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_f_max),
            contentDescription = "Logotipo",
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            "Recuperação de Senha",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            "Digite seu e-mail ou CNPJ cadastrado para receber um link de redefinição",
            color = Color.Gray,
            fontSize = 14.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(48.dp))
        OutlinedTextField(
            value = emailOrCnpj,
            onValueChange = { emailOrCnpj = it },
            label = { Text("E-mail ou CNPJ") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            colors = getTextFieldColors()
        )
        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { viewModel.enviarLinkRecuperacao(emailOrCnpj.text) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = AppYellow),
            enabled = !isLoading // desativa o botão durante carregamento
        ) {
            Text("ENVIAR LINK DE RECUPERAÇÃO", color = DarkBlue, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(16.dp))

        success?.let {
            Text(it, color = Color.Green, fontSize = 14.sp)
        }

        error?.let {
            Text(it, color = Color.Red, fontSize = 14.sp)
        }

        Spacer(modifier = Modifier.height(24.dp))
        TextButton(onClick = { navController.popBackStack() }) {
            Text("Voltar para o login", color = Color.White, fontSize = 14.sp)
        }
    }
}

