package com.example.fletmaxmobile.data.model.dashboard

data class DashboardResponse(
    val totalRotas: Int,
    val rotasPendentes: Int,
    val rotasFinalizadas: Int,
    val totalCaminhoes: Int,
    val caminhoesDisponiveis: Int,
    val totalMotoristas: Int,
    val motoristasAtivos: Int
)
