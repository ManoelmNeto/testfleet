package com.example.fletmaxmobile.e.ui.Telas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.fletmaxmobile.e.model.motorista.Motorista
import com.example.fletmaxmobile.e.ui.AppToolbar
import com.example.fletmaxmobile.e.ui.AppYellow
import com.example.fletmaxmobile.e.ui.DarkBlue
import com.example.fletmaxmobile.e.ui.LightGray
import com.example.fletmaxmobile.e.ui.viewmodel.MotoristaViewModel


@Composable
fun MotoristaScreen(
    navController: NavController,
    viewModel: MotoristaViewModel = viewModel()
) {
    val motoristas by viewModel.motoristas.collectAsState(initial = emptyList())
    val isLoading = viewModel.isLoading
    val errorMessage = viewModel.errorMessage

    LaunchedEffect(Unit) {
        viewModel.carregarMotoristas()
    }

    Scaffold(
        topBar = { AppToolbar(onMenuClicked = { /* Abrir menu */ }) }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(DarkBlue)
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text(
                text = "Motoristas",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            when {
                isLoading -> {
                    Text(text = "Carregando...", color = Color.White)
                }
                errorMessage != null -> {
                    Text(text = "Erro: $errorMessage", color = Color.Red)
                }
                else -> {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(motoristas) { motorista ->
                            DriverCard(motorista = motorista)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DriverCard(motorista: Motorista) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = LightGray)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = motorista.nome,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = DarkBlue
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text("CNH: ${motorista.cnh}", color = Color.Gray)
            Text("Status: ${motorista.status}", color = AppYellow)
        }
    }
}

