package com.example.fletmaxmobile.data.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fletmaxmobile.data.api.ApiClient
import com.example.fletmaxmobile.data.model.rota.Rota
import kotlinx.coroutines.launch

class RotaViewModel : ViewModel() {

    var rotas by mutableStateOf<List<Rota>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun carregarRotas() {
        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            try {
                val response = ApiClient.instance.getRotas()
                if (response.isSuccessful) {
                    rotas = response.body() ?: emptyList()
                } else {
                    errorMessage = "Erro ao buscar rotas: ${response.code()}"
                }
            } catch (e: Exception) {
                errorMessage = "Erro de conexão: ${e.localizedMessage}"
            } finally {
                isLoading = false
            }
        }
    }
}
