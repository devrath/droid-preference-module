package com.droid.code.vm

import android.app.Application
import android.view.View
import com.droid.code.utils.BaseViewModel
import com.droid.repository.RepositoryPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityVm @Inject constructor(
    context: Application,
    private val repositoryPreferences: RepositoryPreferences
) : BaseViewModel(context){

    fun saveAction(text: String) {
        repositoryPreferences.saveTextFromPreferences(text)
    }

    fun displayText() = repositoryPreferences.getTextFromPreferences()

}