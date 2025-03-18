package com.zhalz.eventy.presentation.auth.login

import androidx.lifecycle.MutableLiveData
import com.zhalz.eventy.base.BaseViewModel
import com.zhalz.eventy.data.remote.model.request.LoginRequest
import com.zhalz.eventy.domain.common.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : BaseViewModel() {

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    init {
        email.value = "fool@gmail.com"
        password.value = "123123123123"
    }

    fun login() = flow {
        emit(ApiResult.Loading())
        val result = authRepository.login(
            LoginRequest(email.value.orEmpty(), password.value.orEmpty())
        )
        emit(result)
    }

}