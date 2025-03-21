package com.zhalz.eventy.data.repository

import com.zhalz.eventy.data.remote.ApiService
import com.zhalz.eventy.data.remote.model.response.DivisionResponse
import com.zhalz.eventy.domain.common.ApiResult
import com.zhalz.eventy.domain.repository.DivisionRepository
import com.zhalz.eventy.utils.handleError
import javax.inject.Inject

class DivisionRepositoryImpl @Inject constructor(private val apiService: ApiService) : DivisionRepository {

    override suspend fun getDivisionList(id: Int?): ApiResult<DivisionResponse>  =
        runCatching { apiService.getDivisionList(id) }
            .fold(
                onSuccess = { response -> ApiResult.Success(response) },
                onFailure = { throwable -> ApiResult.Error(throwable.handleError()) }
            )

}