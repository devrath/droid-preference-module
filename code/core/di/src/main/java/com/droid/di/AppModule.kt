package com.droid.di

import android.app.Application
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.droid.preference.Keys.SHARED_PREFERENCES_NAME
import com.droid.preference.datastore.data.AppDatastoreImpl
import com.droid.preference.datastore.domain.AppDatastore
import com.droid.preference.sharedPreferences.data.AppSharedPreferencesImpl
import com.droid.preference.sharedPreferences.domain.AppSharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(
        app: Application
    ): SharedPreferences {
        return app.getSharedPreferences(SHARED_PREFERENCES_NAME, MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun providePreferencesDataStore(@ApplicationContext appContext: Context): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            corruptionHandler = ReplaceFileCorruptionHandler(
                produceNewData = { emptyPreferences() }
            ),
            migrations = listOf(SharedPreferencesMigration(appContext,SHARED_PREFERENCES_NAME)),
            scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
            produceFile = { appContext.preferencesDataStoreFile(SHARED_PREFERENCES_NAME) }
        )
    }

    @Provides
    @Singleton
    fun providePreferences(sharedPreferences: SharedPreferences): AppSharedPreferences {
        return AppSharedPreferencesImpl(sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideDataStorePreferences(dataStore: DataStore<Preferences>): AppDatastore {
        return AppDatastoreImpl(dataStore)
    }

}