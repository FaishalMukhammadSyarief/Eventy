package com.zhalz.eventy.domain.repository

import com.zhalz.eventy.data.remote.model.response.EventResponse
import com.zhalz.eventy.data.remote.model.response.EventsResponse
import com.zhalz.eventy.domain.common.ApiResult

interface EventRepository {

    suspend fun getEvents(): ApiResult<EventsResponse>

    suspend fun getEvent(string: String): ApiResult<EventResponse>

}