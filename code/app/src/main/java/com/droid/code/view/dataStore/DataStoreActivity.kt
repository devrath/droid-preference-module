package com.droid.code.view.dataStore

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.droid.code.R
import com.droid.code.databinding.ActivityDataStoreBinding
import com.droid.code.states.DataStoreViewStates
import com.droid.code.states.SharedPreferenceViewStates
import com.droid.code.utils.hideSoftInput
import com.droid.code.utils.showToast
import com.droid.code.view.sharedPreference.SharedPreferenceVm
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DataStoreActivity : AppCompatActivity()  {

    private lateinit var binding: ActivityDataStoreBinding

    private lateinit var viewModel: DataStoreVm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataStoreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbarBackAction()
        initViewModel()
        setOnClickListeners()
        setupObserver()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setViewState(it: DataStoreViewStates) {
        when(it){
            is DataStoreViewStates.DataSaved -> showToast(resources.getString(R.string.saved))
            is DataStoreViewStates.DataShown -> binding.viewContainerId.txtOutputId.text = it.message
        }
    }

    /**
     * TOOLBAR back action for the screen
     */
    private fun setToolbarBackAction() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    /**
     * Set on click listeners and text change listeners
     */
    private fun setOnClickListeners() {
        binding.viewContainerId.apply {
            inputTextId.editText?.doOnTextChanged { inputText, _, _, _ -> inputTextAction() }
            btnSaveId.setOnClickListener { saveAction(it) }
            btnShowId.setOnClickListener { showAction(it) }
        }
    }

    /**
     * INPUT:-> Edit text actions
     */
    private fun inputTextAction() {  binding.viewContainerId.txtOutputId.text = "" }

    /**
     * ACTION:-> Saving data for the shared preferences
     */
    private fun saveAction(view: View) {
        view.hideSoftInput()
        viewModel.saveAction(binding.viewContainerId.inputTextId.editText?.text.toString())
    }

    /**
     * ACTION:-> Showing data from the shared preferences
     */
    private fun showAction(view: View) {
        view.hideSoftInput()
        viewModel.displayText()
    }

    /**
     * Initialize the view model for the current screen
     */
    private fun initViewModel() { viewModel = ViewModelProvider(this)[DataStoreVm::class.java]
    }

    /**
     * Set the observer for the view states from view model
     */
    private fun setupObserver() {
        lifecycleScope.launchWhenStarted { viewModel.viewState.collect { setViewState(it) } }
    }

}