package com.droid.preference.datastore.data

import android.content.SharedPreferences
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import com.droid.preference.Keys.KEY_TEXT
import com.droid.preference.datastore.domain.AppDatastore
import com.droid.preference.sharedPreferences.domain.AppSharedPreferences
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.io.IOException

class AppDatastoreImpl(
    private val dataStore: DataStore<Preferences>
): AppDatastore {

    companion object {
        private val NAME_KEY_REF = stringPreferencesKey(KEY_TEXT)
    }

    override suspend fun saveText(text: String) {
        dataStore.edit { it[NAME_KEY_REF] = text }
    }

    override suspend  fun loadText(): String {
        return dataStore.getValueFlow(NAME_KEY_REF, "").first()
    }

    private fun <T> DataStore<Preferences>.getValueFlow(
        key: Preferences.Key<T>,
        defaultValue: T,
    ): Flow<T> {
        return this.data
            .catch { exception ->
                if (exception is IOException) { emit(emptyPreferences()) } else { throw exception }
            }.map { preferences ->
                preferences[key] ?: defaultValue
            }
    }

}