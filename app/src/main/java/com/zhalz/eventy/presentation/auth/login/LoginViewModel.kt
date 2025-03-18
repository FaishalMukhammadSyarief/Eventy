package com.zhalz.eventy.presentation.auth.login

import androidx.lifecycle.MutableLiveData
import com.zhalz.eventy.base.BaseViewModel
import com.zhalz.eventy.data.remote.model.request.LoginRequest
import com.zhalz.eventy.data.remote.model.response.AuthData
import com.zhalz.eventy.domain.common.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : BaseViewModel() {

    val email = MutableLiveData<String>()
    val pass = MutableLiveData<String>()

    fun login(remember: Boolean) = flow {
        emit(ApiResult.Loading())
        val result = authRepository.login(
            LoginRequest(email.value.orEmpty(), pass.value.orEmpty())
        )

        if (result is ApiResult.Success) result.data?.authData.let { saveUser(it, remember) }

        emit(result)
    }

    /*  Session  */
    private suspend fun saveUser(authData: AuthData?, remember: Boolean) {
        saveUserSession(authData?.token.orEmpty(), remember)
        saveUserCredential(authData?.person?.name.orEmpty(), authData?.person?.email.orEmpty())
    }

    private suspend fun saveUserSession(token: String, remember: Boolean) =
        sessionRepository.saveUserSession( Pair(token, remember) )

    private suspend fun saveUserCredential(name: String, email: String) =
        sessionRepository.saveUserCredential( Pair(name, email) )

}