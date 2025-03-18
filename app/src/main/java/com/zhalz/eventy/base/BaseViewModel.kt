package com.zhalz.eventy.base

import com.crocodic.core.base.viewmodel.CoreViewModel
import com.zhalz.eventy.data.remote.ApiService
import com.zhalz.eventy.domain.repository.AuthRepository
import javax.inject.Inject

open class BaseViewModel : CoreViewModel() {

    @Inject
    lateinit var apiService: ApiService

    @Inject
    lateinit var authRepository: AuthRepository

    override fun apiLogout() {}

    override fun apiRenewToken() {}

}