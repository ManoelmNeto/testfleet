package com.example.fletmaxmobile.data.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fletmaxmobile.data.api.ApiClient
import com.example.fletmaxmobile.data.model.dashboard.DashboardResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {

    private val _dashboardData = MutableStateFlow<DashboardResponse?>(null)
    val dashboardData: StateFlow<DashboardResponse?> = _dashboardData

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun fetchDashboard() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = ApiClient.instance.getDashboard()
                if (response.isSuccessful) {
                    _dashboardData.value = response.body()
                    _error.value = null
                } else {
                    _error.value = "Erro ao buscar dados"
                }
            } catch (e: Exception) {
                _error.value = "Falha: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
