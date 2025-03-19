package com.zhalz.eventy.presentation.main.home

import com.zhalz.eventy.base.BaseViewModel
import com.zhalz.eventy.domain.common.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel() {

    fun getEvents() = flow {
        emit(ApiResult.Loading())
        val result = eventRepository.getEvents()
        emit(result)
    }

}