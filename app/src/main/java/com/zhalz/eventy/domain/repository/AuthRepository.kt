package com.zhalz.eventy.domain.repository

import com.zhalz.eventy.data.remote.model.request.LoginRequest
import com.zhalz.eventy.data.remote.model.request.OtpRequest
import com.zhalz.eventy.data.remote.model.request.RegisterRequest
import com.zhalz.eventy.data.remote.model.response.AuthResponse
import com.zhalz.eventy.domain.common.ApiResult

interface AuthRepository {

    suspend fun login(request: LoginRequest) : ApiResult<AuthResponse>

    suspend fun register(request: RegisterRequest) : ApiResult<AuthResponse>

    suspend fun verifyOtp(request: OtpRequest) : ApiResult<AuthResponse>

}