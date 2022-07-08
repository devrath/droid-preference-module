package com.droid.code.states

import android.content.Intent
import org.json.JSONObject

sealed class WebViewGameActivityStates {
    object InitialState : WebViewGameActivityStates()
    data class ErrorState(val errorMessage: String) : WebViewGameActivityStates()
}

