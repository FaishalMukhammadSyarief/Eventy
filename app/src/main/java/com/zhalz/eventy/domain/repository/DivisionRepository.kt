package com.zhalz.eventy.domain.repository

import com.zhalz.eventy.data.remote.model.response.DivisionResponse
import com.zhalz.eventy.domain.common.ApiResult

interface DivisionRepository {

    suspend fun getDivisionList(id: Int?): ApiResult<DivisionResponse>

}