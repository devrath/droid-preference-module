package com.droid.preference.domain

interface Preferences {

    fun saveText(text: String)

    fun loadText() : String?

    companion object {
        const val KEY_TEXT = "key_text"
    }

}