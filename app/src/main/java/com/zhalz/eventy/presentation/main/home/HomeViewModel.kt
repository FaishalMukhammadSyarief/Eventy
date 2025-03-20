package com.zhalz.eventy.presentation.main.home

import androidx.lifecycle.viewModelScope
import com.zhalz.eventy.base.BaseViewModel
import com.zhalz.eventy.data.remote.model.response.EventsResponse
import com.zhalz.eventy.domain.common.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel() {

    private val _eventsState = MutableStateFlow<ApiResult<EventsResponse>>(ApiResult.Loading())
    val eventsState: StateFlow<ApiResult<EventsResponse>> = _eventsState

    init {
        fetchEvents()
    }

    fun fetchEvents() = viewModelScope.launch {
        _eventsState.value = ApiResult.Loading()
        _eventsState.value = eventRepository.getEvents()
    }

}