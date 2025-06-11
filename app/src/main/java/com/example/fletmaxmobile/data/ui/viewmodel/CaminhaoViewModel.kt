package com.example.fletmaxmobile.data.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fletmaxmobile.data.api.ApiClient
import com.example.fletmaxmobile.data.model.caminhao.Caminhao
import kotlinx.coroutines.launch

class CaminhaoViewModel : ViewModel() {
    var caminhoes by mutableStateOf<List<Caminhao>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun carregarCaminhoes() {
        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            try {
                val response = ApiClient.instance.getCaminhoes()
                if (response.isSuccessful) {
                    caminhoes = response.body() ?: emptyList()
                } else {
                    errorMessage = "Erro ao carregar caminhões: ${response.code()}"
                }
            } catch (e: Exception) {
                errorMessage = "Erro: ${e.localizedMessage}"
            } finally {
                isLoading = false
            }
        }
    }
}
