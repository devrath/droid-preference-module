package com.droid.repository

import android.content.Context
import com.droid.preference.datastore.domain.AppDatastore

class RepositoryDatastore(
    context: Context,
    val appDatastore: AppDatastore
) {

    suspend fun saveTextFromPreferences(textToSave: String) {
        appDatastore.saveText(textToSave)
    }

    suspend fun getTextFromPreferences(): String? {
        return appDatastore.loadText()
    }

}