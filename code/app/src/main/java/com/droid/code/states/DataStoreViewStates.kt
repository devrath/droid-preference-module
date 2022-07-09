package com.droid.code.states

sealed class DataStoreViewStates {
    object InitialState : DataStoreViewStates()
    object DataSaved : DataStoreViewStates()
    data class DataShown(val message: String) : DataStoreViewStates()
    data class ErrorState(val errorMessage: String) : DataStoreViewStates()
}
