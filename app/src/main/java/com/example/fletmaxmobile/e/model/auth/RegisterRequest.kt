package com.example.fletmaxmobile.e.model.auth

data class RegisterRequest(
    val cnpj: String,
    val razaoSocial: String,
    val email: String,
    val password: String,
    val password_confirmation: String
)
