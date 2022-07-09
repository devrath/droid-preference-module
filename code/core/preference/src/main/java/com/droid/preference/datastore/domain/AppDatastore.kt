package com.droid.preference.datastore.domain

interface AppDatastore {

    suspend fun saveText(text: String)

    suspend fun loadText() : String?

}