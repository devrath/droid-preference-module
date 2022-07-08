package com.droid.preference.data

import android.content.SharedPreferences
import com.droid.preference.domain.Preferences

class DefaultPreferences(
    private val sharedPref: SharedPreferences
): Preferences {

    /** SAVE TEXT - From local preferences **/
    override fun saveText(text: String) {
        sharedPref.edit()
            .putString(Preferences.KEY_TEXT,text)
            .apply()
    }

    /** LOAD TEXT - From local preferences **/
    override fun loadText(): String? {
        return sharedPref.getString(Preferences.KEY_TEXT, null)
    }

}