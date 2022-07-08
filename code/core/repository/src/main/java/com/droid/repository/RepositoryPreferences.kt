package com.droid.repository

import android.content.Context
import java.io.IOException
import com.droid.preference.sharedPreferences.domain.Preferences

class RepositoryPreferences(
    context: Context,
    val preferences: Preferences
) {

    fun saveTextFromPreferences(textToSave: String) {
        preferences.saveText(textToSave)
    }

    fun getTextFromPreferences(): String? {
        return preferences.loadText()
    }

}