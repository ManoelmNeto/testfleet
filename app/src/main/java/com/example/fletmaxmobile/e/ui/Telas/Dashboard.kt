package com.example.fletmaxmobile.e.ui.Telas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.fletmaxmobile.e.ui.AppToolbar
import com.example.fletmaxmobile.e.ui.AppYellow
import com.example.fletmaxmobile.e.ui.DarkBlue
import com.example.fletmaxmobile.e.ui.ErrorRed
import com.example.fletmaxmobile.e.ui.viewmodel.DashboardViewModel

@Composable
fun DashboardScreen(
    navController: NavController,
    viewModel: DashboardViewModel = viewModel()
) {
    val dashboard by viewModel.dashboardData.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchDashboard()
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
                "Dashboard",
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            when {
                isLoading -> {
                    Text("Carregando...", color = Color.White)
                }
                error != null -> {
                    Text("Erro: $error", color = ErrorRed)
                }
                dashboard != null -> {
                    // Exemplo de exibição dos dados do dashboard
                    Text("Motoristas: ${dashboard!!.totalMotoristas}", color = AppYellow, fontSize = 20.sp)
                    Text("Caminhões: ${dashboard!!.totalCaminhoes}", color = AppYellow, fontSize = 20.sp)
                    Text("Rotas Finalizadas: ${dashboard!!.rotasFinalizadas}", color = AppYellow, fontSize = 20.sp)
                }
            }
        }
    }
}


@Composable
fun DashboardCard(icon: ImageVector, count: Int, text: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = icon, contentDescription = text, modifier = Modifier.size(32.dp), tint = DarkBlue)
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(color = AppYellow, fontSize = 20.sp, fontWeight = FontWeight.Bold)) {
                        append("$count ")
                    }
                    withStyle(style = SpanStyle(color = DarkBlue, fontSize = 16.sp)) {
                        append(text)
                    }
                }
            )
        }
    }
}