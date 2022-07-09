package com.droid.code.view.sharedPreference

import android.app.Application
import com.droid.code.states.SharedPreferenceViewStates
import com.droid.code.utils.BaseViewModel
import com.droid.repository.RepositoryPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SharedPreferenceVm @Inject constructor(
    context: Application,
    private val repositoryPreferences: RepositoryPreferences
) : BaseViewModel(context){

    private val _viewState = MutableStateFlow<SharedPreferenceViewStates>(
        SharedPreferenceViewStates.InitialState)
    val viewState = _viewState.asStateFlow()

    fun saveAction(text: String) {
        repositoryPreferences.saveTextFromPreferences(text)
    }

    fun displayText() = repositoryPreferences.getTextFromPreferences()

}