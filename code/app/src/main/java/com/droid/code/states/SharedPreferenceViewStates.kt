package com.droid.code.states

sealed class SharedPreferenceViewStates {
    object InitialState : SharedPreferenceViewStates()
    data class ErrorState(val errorMessage: String) : SharedPreferenceViewStates()
}

