package com.zhalz.eventy.data.remote

import com.zhalz.eventy.data.remote.model.request.LoginRequest
import com.zhalz.eventy.data.remote.model.request.OtpRequest
import com.zhalz.eventy.data.remote.model.request.RegisterRequest
import com.zhalz.eventy.data.remote.model.response.AuthResponse
import com.zhalz.eventy.data.remote.model.response.EventResponse
import com.zhalz.eventy.data.remote.model.response.EventsResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

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

    @DELETE("auth/logout")
    suspend fun logout() : AuthResponse

    @GET("events")
    suspend fun getEvents() : EventsResponse

    @GET("events/{title}")
    suspend fun getEvent(
        @Path("title") title: String?,
    ) : EventResponse

}