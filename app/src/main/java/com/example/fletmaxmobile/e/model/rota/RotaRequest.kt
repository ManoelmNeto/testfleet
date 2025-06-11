package com.example.fletmaxmobile.e.model.rota

data class RotaRequest(
    val origem: String,
    val destino: String,
    val data_saida: String,
    val data_chegada: String,
    val motorista_id: Int,
    val caminhao_id: Int,
    val status: String = "pendente"
)