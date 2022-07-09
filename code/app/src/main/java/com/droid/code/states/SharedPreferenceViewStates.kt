package com.droid.code.states

sealed class SharedPreferenceViewStates {
    object InitialState : SharedPreferenceViewStates()
    object DataSaved : SharedPreferenceViewStates()
    data class DataShown(val message: String) : SharedPreferenceViewStates()
    data class ErrorState(val errorMessage: String) : SharedPreferenceViewStates()
}

