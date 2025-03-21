package com.zhalz.eventy.base

import com.crocodic.core.base.viewmodel.CoreViewModel
import com.zhalz.eventy.data.local.datastore.DataStoreSession
import com.zhalz.eventy.data.remote.ApiService
import com.zhalz.eventy.domain.repository.AuthRepository
import com.zhalz.eventy.domain.repository.DivisionRepository
import com.zhalz.eventy.domain.repository.EventRepository
import com.zhalz.eventy.domain.repository.SessionRepository
import javax.inject.Inject

open class BaseViewModel : CoreViewModel() {

    @Inject
    lateinit var apiService: ApiService

    @Inject
    lateinit var dataStoreSession: DataStoreSession

    @Inject
    lateinit var authRepository: AuthRepository

    @Inject
    lateinit var sessionRepository: SessionRepository

    @Inject
    lateinit var eventRepository: EventRepository

    @Inject
    lateinit var divisionRepository: DivisionRepository

    override fun apiLogout() {}

    override fun apiRenewToken() {}

}