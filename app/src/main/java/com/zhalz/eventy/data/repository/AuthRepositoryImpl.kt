package com.zhalz.eventy.data.repository

import com.zhalz.eventy.data.remote.ApiService
import com.zhalz.eventy.data.remote.model.request.LoginRequest
import com.zhalz.eventy.data.remote.model.request.OtpRequest
import com.zhalz.eventy.data.remote.model.request.RegisterRequest
import com.zhalz.eventy.data.remote.model.response.AuthResponse
import com.zhalz.eventy.domain.common.ApiResult
import com.zhalz.eventy.domain.repository.AuthRepository
import com.zhalz.eventy.utils.handleError
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val apiService: ApiService) : AuthRepository {

    override suspend fun login(request: LoginRequest): ApiResult<AuthResponse> =
        runCatching { apiService.login(request) }
            .fold(
                onSuccess = { data -> ApiResult.Success(data) },
                onFailure = { throwable -> ApiResult.Error(throwable.handleError()) }
            )

    override suspend fun register(request: RegisterRequest): ApiResult<AuthResponse> =
        runCatching { apiService.register(request) }
            .fold(
                onSuccess = { data -> ApiResult.Success(data) },
                onFailure = { throwable -> ApiResult.Error(throwable.handleError()) }
            )

    override suspend fun verifyOtp(request: OtpRequest): ApiResult<AuthResponse> =
        runCatching { apiService.verifyOtp(request) }
            .fold(
                onSuccess = { data -> ApiResult.Success(data) },
                onFailure = { throwable -> ApiResult.Error(throwable.handleError()) }
            )

    override suspend fun logout(): ApiResult<AuthResponse> =
        runCatching { apiService.logout() }
            .fold(
                onSuccess = { data -> ApiResult.Success(data) },
                onFailure = { throwable -> ApiResult.Error(throwable.handleError()) }
            )

}