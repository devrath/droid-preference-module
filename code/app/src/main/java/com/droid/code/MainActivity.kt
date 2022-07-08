package com.droid.code

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import com.droid.code.databinding.ActivityMainBinding
import com.droid.code.utils.hideSoftInput
import com.droid.preference.domain.Preferences
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.apply {
            inputTextId.editText?.doOnTextChanged { inputText, _, _, _ -> inputTextAction() }
            btnSaveId.setOnClickListener { saveAction(it) }
            btnShowId.setOnClickListener { showAction(it) }
        }
    }

    private fun inputTextAction() { displayText("") }

    private fun saveAction(view: View) {
        view.hideSoftInput()
        val textToSave = binding.inputTextId.editText?.text.toString()
        preferences.saveText(textToSave)
    }

    private fun showAction(view: View) {
        view.hideSoftInput()
        val textToShow = preferences.loadText()
        displayText(textToShow)
    }

    private fun displayText(textToShow: String?) {
        binding.txtOutputId.text = textToShow
    }

}