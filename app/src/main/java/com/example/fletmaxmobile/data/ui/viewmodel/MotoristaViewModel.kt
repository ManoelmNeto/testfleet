package com.example.fletmaxmobile.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fletmaxmobile.data.api.ApiClient
import com.example.fletmaxmobile.data.model.motorista.Motorista
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MotoristaViewModel : ViewModel() {

    private val _motoristas = MutableStateFlow<List<Motorista>>(emptyList())
    val motoristas = _motoristas.asStateFlow()

    var isLoading = false
        private set

    var errorMessage: String? = null
        private set

    fun carregarMotoristas() {
        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            try {
                val response = ApiClient.instance.getMotoristas()
                if (response.isSuccessful) {
                    _motoristas.value = response.body() ?: emptyList()
                } else {
                    errorMessage = "Erro ${response.code()}: ${response.message()}"
                }
            } catch (e: Exception) {
                errorMessage = "Erro ao carregar motoristas: ${e.message}"
            } finally {
                isLoading = false
            }
        }
    }
}
