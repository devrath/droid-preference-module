package com.droid.code.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast

fun View.hideSoftInput() {
    val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
}

inline fun <reified T : Activity> Context.startActivity(block: Intent.() -> Unit = {}) {
    startActivity(Intent(this, T::class.java).apply(block))
}

fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this, message , duration).show()
}