package com.zhalz.eventy.domain.repository

import androidx.datastore.preferences.core.Preferences

interface SessionRepository {

    suspend fun saveUserSession(session: Pair<String, Boolean>) : Preferences
    suspend fun getUserSession() : Pair<String?, Boolean?>

    suspend fun saveUserCredential(user: Pair<String, String>) : Preferences
    suspend fun getUserCredential() : Pair<String?, String?>

    suspend fun clearUser() : Preferences

}