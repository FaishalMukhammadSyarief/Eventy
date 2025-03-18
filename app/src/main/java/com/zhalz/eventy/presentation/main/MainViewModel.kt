package com.zhalz.eventy.presentation.main

import androidx.lifecycle.viewModelScope
import com.zhalz.eventy.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel() {

    fun logout() = viewModelScope.launch {
        authRepository.logout()
    }

    fun clearUser() = viewModelScope.launch {
        sessionRepository.clearUser()
    }
}