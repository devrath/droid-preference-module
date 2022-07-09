package com.droid.preference.sharedPreferences.domain

interface AppSharedPreferences {

    fun saveText(text: String)

    fun loadText() : String?

}