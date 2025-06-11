package com.example.fletmaxmobile.data.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PasswordRecoveryViewModel : ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _successMessage = MutableStateFlow<String?>(null)
    val successMessage: StateFlow<String?> = _successMessage

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    fun enviarLinkRecuperacao(emailOuCnpj: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _successMessage.value = null
            _errorMessage.value = null

            delay(1500) // Simula tempo de envio

            if (emailOuCnpj.isNotBlank()) {
                _successMessage.value = "Link enviado com sucesso para $emailOuCnpj"
            } else {
                _errorMessage.value = "Por favor, insira um e-mail ou CNPJ válido."
            }

            _isLoading.value = false
        }
    }
}
