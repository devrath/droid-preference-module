package com.droid.di

import android.content.Context
import com.droid.preference.datastore.domain.AppDatastore
import com.droid.preference.sharedPreferences.domain.AppSharedPreferences
import com.droid.repository.RepositoryDatastore
import com.droid.repository.RepositoryPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepositoryPreferences(
        @ApplicationContext context: Context,
        appSharedPreferences: AppSharedPreferences
    ) = RepositoryPreferences(context = context,appSharedPreferences=appSharedPreferences)


    @Provides
    @Singleton
    fun provideRepositoryDatastore(
        @ApplicationContext context: Context,
        store: AppDatastore
    ) = RepositoryDatastore(context = context, appDatastore = store)

}