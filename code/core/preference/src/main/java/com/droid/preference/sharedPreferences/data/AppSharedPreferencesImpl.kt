package com.droid.preference.sharedPreferences.data

import android.content.SharedPreferences
import com.droid.preference.Keys.KEY_TEXT
import com.droid.preference.sharedPreferences.domain.AppSharedPreferences

class AppSharedPreferencesImpl(
    private val sharedPref: SharedPreferences
): AppSharedPreferences {

    /** SAVE TEXT - From local preferences **/
    override fun saveText(text: String) {
        sharedPref.edit()
            .putString(KEY_TEXT,text)
            .apply()
    }

    /** LOAD TEXT - From local preferences **/
    override fun loadText(): String? {
        return sharedPref.getString(KEY_TEXT, null)
    }

}