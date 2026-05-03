package com.everallity.ecommerceandroidapp.core.util

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TokenManager @Inject constructor(
    @ApplicationContext private val context: Context,
    private val datastore: DataStore<Preferences>
) {
    private val TOKEN_KEY = stringPreferencesKey("jwt_token")

    suspend fun saveToken(token: String) {
        datastore.edit { preferences -> preferences[TOKEN_KEY] = token }
    }

    val tokenFlow: Flow<String?> = datastore.data.map { preferences -> preferences[TOKEN_KEY] }

    suspend fun clearToken() {
        datastore.edit { preferences -> preferences.remove(TOKEN_KEY) }
    }

    suspend fun getSyncToken(): String? = tokenFlow.first()
}