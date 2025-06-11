package com.example.fletmaxmobile.e.api

import com.example.fletmaxmobile.e.model.GenericResponse
import com.example.fletmaxmobile.e.model.auth.LoginRequest
import com.example.fletmaxmobile.e.model.auth.LoginResponse
import com.example.fletmaxmobile.e.model.auth.RegisterRequest
import com.example.fletmaxmobile.e.model.caminhao.Caminhao
import com.example.fletmaxmobile.e.model.dashboard.DashboardResponse
import com.example.fletmaxmobile.e.model.motorista.Motorista
import com.example.fletmaxmobile.e.model.rota.Rota
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    // --- Auth ---
    @POST("mobile/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @POST("mobile/register")
    suspend fun register(@Body request: RegisterRequest): Response<GenericResponse>

    // --- Dashboard ---
    @GET("mobile/dashboard")
    suspend fun getDashboard(): Response<DashboardResponse>

    // --- Caminhões ---
    @GET("mobile/caminhoes")
    suspend fun getCaminhoes(): Response<List<Caminhao>>

    // --- Motoristas ---
    @GET("mobile/motoristas")
    suspend fun getMotoristas(): Response<List<Motorista>>

    // --- Rotas ---
    @GET("mobile/rotas")
    suspend fun getRotas(): Response<List<Rota>>
}

