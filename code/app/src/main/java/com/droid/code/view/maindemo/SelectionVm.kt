package com.droid.code.view.maindemo

import android.app.Application
import com.droid.code.utils.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SelectionVm @Inject constructor(
    context: Application
)  : BaseViewModel(context){

}