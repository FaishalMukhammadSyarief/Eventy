package com.zhalz.eventy.presentation.event

import androidx.lifecycle.viewModelScope
import com.zhalz.eventy.base.BaseViewModel
import com.zhalz.eventy.data.remote.model.response.DivisionResponse
import com.zhalz.eventy.data.remote.model.response.EventResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import com.zhalz.eventy.domain.common.ApiResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventViewModel @Inject constructor() : BaseViewModel() {

    private val _eventState = MutableStateFlow<ApiResult<EventResponse>>(ApiResult.Loading())
    val eventState: StateFlow<ApiResult<EventResponse>> = _eventState

    fun getEvent(title: String) = viewModelScope.launch {
        _eventState.value = ApiResult.Loading()
        _eventState.value = eventRepository.getEvent(title)
    }

    private val _divisionListState = MutableStateFlow<ApiResult<DivisionResponse>>(ApiResult.Loading())
    val divisionListState: StateFlow<ApiResult<DivisionResponse>> = _divisionListState

    fun fetchDivisionList(id: Int?) = viewModelScope.launch {
        _divisionListState.value = ApiResult.Loading()
        _divisionListState.value = divisionRepository.getDivisionList(id)
    }

}