package com.zhalz.eventy.presentation.event

import com.zhalz.eventy.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import com.zhalz.eventy.domain.common.ApiResult
import javax.inject.Inject

@HiltViewModel
class EventViewModel @Inject constructor() : BaseViewModel() {

    fun getEvent(id: Int) = flow {
        emit(ApiResult.Loading())
        val result = eventRepository.getEvent(id)
        emit(result)
    }

}