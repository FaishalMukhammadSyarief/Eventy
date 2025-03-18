package com.zhalz.eventy.data.repository

import com.zhalz.eventy.data.remote.ApiService
import com.zhalz.eventy.data.remote.model.request.LoginRequest
import com.zhalz.eventy.data.remote.model.response.AuthResponse
import com.zhalz.eventy.domain.common.ApiResult
import com.zhalz.eventy.domain.repository.AuthRepository
import com.zhalz.eventy.utils.handleError
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val apiService: ApiService) : AuthRepository {

    override suspend fun login(request: LoginRequest): ApiResult<AuthResponse> =
        runCatching { apiService.login(request) }
            .fold(
                onSuccess = { response -> ApiResult.Success(response) },
                onFailure = { throwable -> ApiResult.Error(throwable.handleError()) }
            )

}