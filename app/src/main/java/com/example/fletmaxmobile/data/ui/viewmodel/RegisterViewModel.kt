package com.example.fletmaxmobile.data.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fletmaxmobile.data.api.ApiClient
import com.example.fletmaxmobile.data.model.auth.RegisterRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _success = MutableStateFlow(false)
    val success: StateFlow<Boolean> = _success

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun register(request: RegisterRequest) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = ApiClient.instance.register(request)
                if (response.isSuccessful) {
                    _success.value = true
                    _error.value = null
                } else {
                    _error.value = "Erro ao registrar: ${response.code()}"
                }
            } catch (e: Exception) {
                _error.value = "Falha de rede: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun clearState() {
        _success.value = false
        _error.value = null
    }
}
