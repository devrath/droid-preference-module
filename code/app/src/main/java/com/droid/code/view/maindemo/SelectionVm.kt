package com.droid.code.view.maindemo

import android.app.Application
import com.droid.code.states.SelectionViewStates
import com.droid.code.states.SharedPreferenceViewStates
import com.droid.code.utils.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SelectionVm @Inject constructor(
    context: Application
)  : BaseViewModel(context){

    private val _viewState = MutableStateFlow<SelectionViewStates>(
        SelectionViewStates.InitialState)
    val viewState = _viewState.asStateFlow()

    fun initiateMigration() {

    }

}