package com.example.fletmaxmobile.e.ui.Telas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.fletmaxmobile.e.model.caminhao.Caminhao
import com.example.fletmaxmobile.e.model.motorista.Motorista
import com.example.fletmaxmobile.e.model.rota.Rota
import com.example.fletmaxmobile.e.ui.AppToolbar
import com.example.fletmaxmobile.e.ui.AppYellow
import com.example.fletmaxmobile.e.ui.DarkBlue
import com.example.fletmaxmobile.e.ui.ErrorRed
import com.example.fletmaxmobile.e.ui.LightGray
import com.example.fletmaxmobile.e.ui.viewmodel.RotaViewModel

@Composable
fun RotasScreen(
    navController: NavController,
    viewModel: RotaViewModel = viewModel()
) {
    val rotas = viewModel.rotas
    val isLoading = viewModel.isLoading
    val errorMessage = viewModel.errorMessage

    LaunchedEffect(Unit) {
        viewModel.carregarRotas()
    }

    Scaffold(
        topBar = { AppToolbar(onMenuClicked = { /* menu lateral */ }) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(DarkBlue)
                .padding(paddingValues)
        ) {
            Text(
                "Rotas",
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )

            when {
                isLoading -> {
                    Text("Carregando rotas...", color = Color.White, modifier = Modifier.padding(16.dp))
                }
                errorMessage != null -> {
                    Text("Erro: $errorMessage", color = ErrorRed, modifier = Modifier.padding(16.dp))
                }
                else -> {
                    LazyColumn(
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(rotas.size) { index ->
                            RouteCard(rotação = rotas[index])
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RouteCard(rotação: Rota) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = LightGray)
    ) {
        Column(Modifier.padding(16.dp)) {
            Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween, Alignment.Top) {
                Text("#${rotação.id}", color = DarkBlue, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text("Status: ${rotação.status}", color = AppYellow, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.height(12.dp))
            RouteInfoRow("Origem:", rotação.origem)
            RouteInfoRow("Destino:", rotação.destino)
            RouteInfoRow("Saída:", rotação.data_saida)
            RouteInfoRow("Chegada:", rotação.data_chegada)
            RouteInfoRow("Motorista:", rotação.motorista.nome)
            RouteInfoRow("Caminhão:", rotação.caminhao.modelo)
            Spacer(Modifier.height(8.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                Button(
                    onClick = { /* TODO: Navegar para detalhes da rota */ },
                    colors = ButtonDefaults.buttonColors(containerColor = AppYellow),
                    contentPadding = PaddingValues(horizontal = 24.dp)
                ) {
                    Text("Detalhada", color = DarkBlue, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun PreviewRotasScreen() {
    val motorista = Motorista(id = 1, nome = "João Silva", cnh = "12345678900", status = "ativo")
    val caminhao = Caminhao(id = 1, placa = "ABC1234", modelo = "Volvo FH", status = "ativo")

    val rotasExemplo = listOf(
        Rota(
            id = 1010,
            origem = "Fortaleza - CE",
            destino = "Juazeiro do Norte - CE",
            data_saida = "2025-06-10",
            data_chegada = "2025-06-11",
            status = "pendente",
            motorista = motorista,
            caminhao = caminhao
        )
    )

}
@Composable
fun RouteInfoRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, color = Color.Gray, fontSize = 14.sp)
        Text(text = value, color = Color.Black, fontSize = 14.sp)
    }
}
