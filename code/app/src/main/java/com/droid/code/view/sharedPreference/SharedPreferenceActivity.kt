package com.droid.code.view.sharedPreference

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import com.droid.code.databinding.ActivityMainBinding
import com.droid.code.utils.hideSoftInput
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SharedPreferenceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: SharedPreferenceVm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbarBackAction()
        initViewModel();
        setOnClickListeners()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setToolbarBackAction() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
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
        viewModel.saveAction(textToSave)
    }

    private fun showAction(view: View) {
        view.hideSoftInput()
        displayText(viewModel.displayText())
    }

    private fun displayText(textToShow: String?) {
        binding.txtOutputId.text = textToShow
    }

    private fun initViewModel() { viewModel = ViewModelProvider(this).get(SharedPreferenceVm::class.java) }

}