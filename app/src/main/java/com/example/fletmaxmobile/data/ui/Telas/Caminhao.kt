package com.example.fletmaxmobile.data.ui.Telas

import androidx.compose.foundation.background
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fletmaxmobile.data.model.caminhao.Caminhao
import com.example.fletmaxmobile.data.ui.AppToolbar
import com.example.fletmaxmobile.data.ui.AppYellow
import com.example.fletmaxmobile.data.ui.DarkBlue
import com.example.fletmaxmobile.data.ui.DarkCard
import com.example.fletmaxmobile.data.ui.ErrorRed
import com.example.fletmaxmobile.data.ui.TextGray
import com.example.fletmaxmobile.data.ui.viewmodel.CaminhaoViewModel
import androidx.compose.foundation.lazy.items



@Composable
fun CaminhaoScreen(navController: NavController) {
    val caminhaoViewModel: CaminhaoViewModel = viewModel()
    val caminhoes = caminhaoViewModel.caminhoes
    val isLoading = caminhaoViewModel.isLoading
    val errorMessage = caminhaoViewModel.errorMessage

    LaunchedEffect(Unit) {
        caminhaoViewModel.carregarCaminhoes()
    }

    Scaffold(
        topBar = { AppToolbar(onMenuClicked = { /* TODO: menu */ }) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(DarkBlue)
                .padding(paddingValues)
        ) {
            Text(
                "Caminhões",
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )

            when {
                isLoading -> {
                    Text("Carregando...", color = Color.White, modifier = Modifier.padding(16.dp))
                }
                errorMessage != null -> {
                    Text("Erro: $errorMessage", color = ErrorRed, modifier = Modifier.padding(16.dp))
                }
                else -> {
                    LazyColumn(
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(caminhoes) { caminhao ->
                            TruckCard(caminhao = caminhao)
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun TruckCard(caminhao: Caminhao) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = DarkCard)
    ) {
        Column(Modifier.padding(16.dp)) {
            Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween, Alignment.CenterVertically) {
                Text(caminhao.modelo, color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text("#${caminhao.id}", color = TextGray, fontSize = 14.sp)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.LocalShipping, contentDescription = "Placa", tint = TextGray)
                Spacer(Modifier.width(8.dp))
                Text(caminhao.placa, color = Color.White, fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.height(16.dp))
            TruckInfoRow("Status:", caminhao.status)
            TruckInfoRow("Numeração do veículo:", caminhao.id.toString()) // Pode ser substituído por outro campo real
            HorizontalDivider(color = TextGray, thickness = 1.dp, modifier = Modifier.padding(vertical = 8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                TextButton(onClick = { /* TODO: Editar */ }) { Text("Editar", color = AppYellow) }
                TextButton(onClick = { /* TODO: Excluir */ }) { Text("Excluir", color = ErrorRed) }
            }
        }
    }
}

@Composable
fun TruckInfoRow(label: String, value: String) {
    Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
        Text(label, color = TextGray, fontSize = 14.sp)
        Text(value, color = Color.White, fontSize = 14.sp)
    }
}
