package com.zhalz.eventy.data.repository

import com.zhalz.eventy.data.remote.ApiService
import com.zhalz.eventy.data.remote.model.response.EventResponse
import com.zhalz.eventy.domain.common.ApiResult
import com.zhalz.eventy.domain.repository.EventRepository
import com.zhalz.eventy.utils.handleError
import javax.inject.Inject

class EventRepositoryImpl @Inject constructor(private val apiService: ApiService) : EventRepository {

    override suspend fun getEvent(): ApiResult<EventResponse> =
        runCatching { apiService.getEvent() }
            .fold(
                onSuccess = { response -> ApiResult.Success(response) },
                onFailure = { throwable -> ApiResult.Error(throwable.handleError()) }
            )

}