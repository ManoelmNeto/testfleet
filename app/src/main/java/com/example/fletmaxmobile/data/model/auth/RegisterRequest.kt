package com.example.fletmaxmobile.data.model.auth

data class RegisterRequest(
    val cnpj: String,
    val razaoSocial: String,
    val email: String,
    val password: String,
    val password_confirmation: String
)
