package com.droid.code.view.dataStore

import android.app.Application
import com.droid.code.states.DataStoreViewStates
import com.droid.code.states.SharedPreferenceViewStates
import com.droid.code.utils.BaseViewModel
import com.droid.repository.RepositoryPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DataStoreVm @Inject constructor(
    context: Application
) : BaseViewModel(context){

    private val _viewState = MutableStateFlow<DataStoreViewStates>(
        DataStoreViewStates.InitialState)
    val viewState = _viewState.asStateFlow()



}