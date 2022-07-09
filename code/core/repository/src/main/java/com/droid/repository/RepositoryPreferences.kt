package com.droid.repository

import android.content.Context
import com.droid.preference.sharedPreferences.domain.AppSharedPreferences

class RepositoryPreferences(
    context: Context,
    val appSharedPreferences: AppSharedPreferences
) {

    fun saveTextFromPreferences(textToSave: String) {
        appSharedPreferences.saveText(textToSave)
    }

    fun getTextFromPreferences(): String? {
        return appSharedPreferences.loadText()
    }

}