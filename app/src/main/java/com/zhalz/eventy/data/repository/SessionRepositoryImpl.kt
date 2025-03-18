package com.zhalz.eventy.data.repository

import androidx.datastore.preferences.core.Preferences
import com.zhalz.eventy.data.local.datastore.DataStoreSession
import com.zhalz.eventy.domain.repository.SessionRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class SessionRepositoryImpl @Inject constructor(private val dataStoreSession: DataStoreSession): SessionRepository {

    override suspend fun saveUserSession(session: Pair<String, Boolean>): Preferences = dataStoreSession.setUserSession(session)
    override suspend fun getUserSession(): Pair<String?, Boolean?> = dataStoreSession.getUserSession().first()

    override suspend fun saveUserCredential(user: Pair<String, String>): Preferences = dataStoreSession.setUserCredentials(user)
    override suspend fun getUserCredential(): Pair<String?, String?> = dataStoreSession.getUserCredentials().first()

    override suspend fun clearUser(): Preferences = dataStoreSession.clearUserCredentials()

}