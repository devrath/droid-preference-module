package com.droid.code.states

sealed class SelectionViewStates {
    object InitialState : SelectionViewStates()
    data class ErrorState(val errorMessage: String) : SelectionViewStates()
}
