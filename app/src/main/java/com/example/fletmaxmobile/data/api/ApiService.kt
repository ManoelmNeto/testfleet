package com.example.fletmaxmobile.data.api

import com.example.fletmaxmobile.data.model.GenericResponse
import com.example.fletmaxmobile.data.model.auth.LoginRequest
import com.example.fletmaxmobile.data.model.auth.LoginResponse
import com.example.fletmaxmobile.data.model.auth.RegisterRequest
import com.example.fletmaxmobile.data.model.caminhao.Caminhao
import com.example.fletmaxmobile.data.model.caminhao.CaminhaoRequest
import com.example.fletmaxmobile.data.model.dashboard.DashboardResponse
import com.example.fletmaxmobile.data.model.motorista.Motorista
import com.example.fletmaxmobile.data.model.motorista.MotoristaRequest
import com.example.fletmaxmobile.data.model.rota.Rota
import com.example.fletmaxmobile.data.model.rota.RotaRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {

    // --- Auth ---
    @POST("mobile/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @POST("mobile/register")
    suspend fun register(@Body request: RegisterRequest): Response<GenericResponse>

    @POST("mobile/logout")
    suspend fun logout(): Response<GenericResponse>


    // --- Dashboard ---
    @GET("mobile/dashboard")
    suspend fun getDashboard(): Response<DashboardResponse>


    // --- Caminhões ---
    @GET("mobile/caminhoes")
    suspend fun getCaminhoes(): Response<List<Caminhao>>

    @POST("mobile/caminhoes")
    suspend fun createCaminhao(@Body caminhao: CaminhaoRequest): Response<GenericResponse>

    @PUT("mobile/caminhoes/{id}")
    suspend fun updateCaminhao(@Path("id") id: Int, @Body caminhao: CaminhaoRequest): Response<GenericResponse>

    @DELETE("mobile/caminhoes/{id}")
    suspend fun deleteCaminhao(@Path("id") id: Int): Response<GenericResponse>


    // --- Motoristas ---
    @GET("mobile/motoristas")
    suspend fun getMotoristas(): Response<List<Motorista>>

    @POST("mobile/motoristas")
    suspend fun createMotorista(@Body motorista: MotoristaRequest): Response<GenericResponse>

    @PUT("mobile/motoristas/{id}")
    suspend fun updateMotorista(@Path("id") id: Int, @Body motorista: MotoristaRequest): Response<GenericResponse>

    @DELETE("mobile/motoristas/{id}")
    suspend fun deleteMotorista(@Path("id") id: Int): Response<GenericResponse>


    // --- Rotas ---
    @GET("mobile/rotas")
    suspend fun getRotas(): Response<List<Rota>>

    @POST("mobile/rotas")
    suspend fun createRota(@Body rota: RotaRequest): Response<GenericResponse>

    @GET("mobile/rotas/{id}")
    suspend fun getRota(@Path("id") id: Int): Response<Rota>

    @PUT("mobile/rotas/{id}")
    suspend fun updateRota(@Path("id") id: Int, @Body rota: RotaRequest): Response<GenericResponse>

    @DELETE("mobile/rotas/{id}")
    suspend fun deleteRota(@Path("id") id: Int): Response<GenericResponse>
}
