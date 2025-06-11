package com.example.fletmaxmobile.data.model.rota
import com.example.fletmaxmobile.data.model.caminhao.Caminhao
import com.example.fletmaxmobile.data.model.motorista.Motorista

data class Rota(
    val id: Int,
    val origem: String,
    val destino: String,
    val data_saida: String,
    val data_chegada: String,
    val status: String,
    val motorista: Motorista,
    val caminhao: Caminhao
)
