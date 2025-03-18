package com.zhalz.eventy.data.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.zhalz.eventy.utils.Constanta.DataStore.User.DATA_STORE_NAME
import com.zhalz.eventy.utils.Constanta.DataStore.User.TOKEN_KEY
import com.zhalz.eventy.utils.Constanta.DataStore.User.NAME_KEY
import com.zhalz.eventy.utils.Constanta.DataStore.User.EMAIL_KEY
import com.zhalz.eventy.utils.Constanta.DataStore.User.REMEMBER_KEY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStoreSession(context: Context) {

    private val Context.datastore: DataStore<Preferences> by preferencesDataStore(DATA_STORE_NAME)
    private val dataStore = context.datastore

    /*  User Session */
    suspend fun setUserSession(session: Pair<String, Boolean>) = dataStore.edit {
        it[tokenKey] = session.first
        it[rememberKey] = session.second
    }

    fun getUserSession(): Flow<Pair<String?, Boolean?>> = dataStore.data.map {
        val token = it[tokenKey]
        val remember = it[rememberKey]
        Pair(token, remember)
    }

    /*  User Credential */
    suspend fun setUserCredentials(user: Pair<String, String>) = dataStore.edit {
        it[nameKey] = user.first
        it[emailKey] = user.second
    }

    fun getUserCredentials(): Flow<Pair<String?, String?>> = dataStore.data.map {
        val name = it[nameKey]
        val email = it[emailKey]
        Pair(name, email)
    }

    /*  Clear User */
    suspend fun clearUserCredentials() = dataStore.edit {
        it.remove(tokenKey)
        it.remove(rememberKey)

        it.remove(nameKey)
        it.remove(emailKey)
    }

    companion object {
        private val tokenKey = stringPreferencesKey(TOKEN_KEY)
        private val rememberKey = booleanPreferencesKey(REMEMBER_KEY)

        private val nameKey = stringPreferencesKey(NAME_KEY)
        private val emailKey = stringPreferencesKey(EMAIL_KEY)
    }

}