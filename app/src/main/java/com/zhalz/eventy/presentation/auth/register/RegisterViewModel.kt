package com.zhalz.eventy.presentation.auth.register

import androidx.lifecycle.MutableLiveData
import com.zhalz.eventy.base.BaseViewModel
import com.zhalz.eventy.data.remote.model.request.OtpRequest
import com.zhalz.eventy.data.remote.model.request.RegisterRequest
import com.zhalz.eventy.domain.common.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(): BaseViewModel() {

    val username = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val phone = MutableLiveData<String>()
    val pass = MutableLiveData<String>()
    val passConfirm = MutableLiveData<String>()

    fun register() = flow {
        emit(ApiResult.Loading())
        val result = authRepository.register(
            RegisterRequest(
                username.value.orEmpty(),
                email.value.orEmpty(),
                phone.value.orEmpty(),
                pass.value.orEmpty(),
                passConfirm.value.orEmpty()
            )
        )
        emit(result)
    }

    fun verifyOtp(otp: Int) = flow {
        emit(ApiResult.Loading())
        val result = authRepository.verifyOtp( OtpRequest(otp) )
        emit(result)
    }
}