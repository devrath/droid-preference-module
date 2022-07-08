package com.droid.di

import android.content.Context
import com.droid.preference.sharedPreferences.domain.Preferences
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
        preferences: Preferences
    ) = RepositoryPreferences(context = context,preferences=preferences)

}