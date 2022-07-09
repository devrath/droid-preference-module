package com.droid.code.view.dataStore

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.droid.code.states.DataStoreViewStates
import com.droid.code.states.SharedPreferenceViewStates
import com.droid.code.utils.BaseViewModel
import com.droid.repository.RepositoryDatastore
import com.droid.repository.RepositoryPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataStoreVm @Inject constructor(
    context: Application,
    private val repositoryDatastore: RepositoryDatastore
) : BaseViewModel(context){

    private val _viewState = MutableStateFlow<DataStoreViewStates>(
        DataStoreViewStates.InitialState)
    val viewState = _viewState.asStateFlow()


    fun saveAction(text: String) {
        viewModelScope.launch {
            repositoryDatastore.saveTextFromPreferences(text)
            _viewState.value = DataStoreViewStates.DataSaved
        }
    }

    fun displayText() {
        viewModelScope.launch {
            repositoryDatastore.getTextFromPreferences()?.let {
                _viewState.value = DataStoreViewStates.DataShown(it)
            }
        }
    }

}