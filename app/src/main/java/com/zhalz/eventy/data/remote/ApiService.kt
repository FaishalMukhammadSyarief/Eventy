package com.zhalz.eventy.data.remote

import com.zhalz.eventy.data.remote.model.request.LoginRequest
import com.zhalz.eventy.data.remote.model.request.OtpRequest
import com.zhalz.eventy.data.remote.model.request.RegisterRequest
import com.zhalz.eventy.data.remote.model.response.AuthResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("auth/login")
    suspend fun login(
        @Body request: LoginRequest
    ) : AuthResponse

    @POST("auth/register")
    suspend fun register(
        @Body request: RegisterRequest
    ) : AuthResponse

    @POST("auth/verify-otp")
    suspend fun verifyOtp(
        @Body request: OtpRequest
    ) : AuthResponse

}