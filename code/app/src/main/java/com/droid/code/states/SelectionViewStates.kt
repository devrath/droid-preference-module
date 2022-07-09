package com.droid.code.states

sealed class SelectionViewStates {
    object InitialState : SelectionViewStates()
    object MigrationSuccessful : SelectionViewStates()
    data class ErrorState(val errorMessage: String) : SelectionViewStates()
}
