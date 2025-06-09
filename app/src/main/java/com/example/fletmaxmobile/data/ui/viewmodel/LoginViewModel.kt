package com.example.fletmaxmobile.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fletmaxmobile.data.api.ApiClient
import com.example.fletmaxmobile.data.model.auth.LoginRequest
import com.example.fletmaxmobile.data.model.auth.LoginResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginViewModel : ViewModel() {



    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password


    private val _loginResult = MutableStateFlow<Result<LoginResponse>?>(null)
    val loginResult: StateFlow<Result<LoginResponse>?> = _loginResult


    fun onEmailChanged(value: String) {
        _email.value = value
    }

    fun onPasswordChanged(value: String) {
        _password.value = value
    }

    fun login() {
        val request = LoginRequest(
            email = _email.value,
            password = _password.value
        )

        viewModelScope.launch {
            try {
                val response: Response<LoginResponse> = ApiClient.instance.login(request)
                if (response.isSuccessful && response.body() != null) {
                    _loginResult.value = Result.success(response.body()!!)
                } else {
                    _loginResult.value = Result.failure(Exception("Erro ao fazer login: ${response.code()}"))
                }
            } catch (e: Exception) {
                _loginResult.value = Result.failure(e)
            }
        }
    }
}
