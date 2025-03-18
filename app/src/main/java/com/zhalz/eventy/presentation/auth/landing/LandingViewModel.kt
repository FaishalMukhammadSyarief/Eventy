package com.zhalz.eventy.presentation.auth.landing

import com.zhalz.eventy.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LandingViewModel @Inject constructor() : BaseViewModel() {

    suspend fun getUserSession() = sessionRepository.getUserSession()

    suspend fun clearUser() = sessionRepository.clearUser()

}