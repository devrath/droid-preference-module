package com.droid.code.view.maindemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.droid.code.R
import com.droid.code.databinding.ActivitySelectionBinding
import com.droid.code.states.SelectionViewStates
import com.droid.code.utils.showToast
import com.droid.code.utils.startActivity
import com.droid.code.view.sharedPreference.SharedPreferenceActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SelectionActivity : AppCompatActivity()  {

    private lateinit var binding: ActivitySelectionBinding

    private lateinit var viewModel: SelectionVm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel();
        setOnClickListeners()
        setupObserver()
    }

    private fun initViewModel() { viewModel = ViewModelProvider(this)[SelectionVm::class.java] }

    private fun setOnClickListeners() {
        binding.apply {
            btnSharedPrefsId.setOnClickListener { startActivity<SharedPreferenceActivity>() }
            btnMigrateId.setOnClickListener { viewModel.initiateMigration() }
            btnDataStoreId.setOnClickListener { startDataStoreScreen() }
        }
    }

    private fun startDataStoreScreen() {

    }

    /**
     * Set the observer for the view states from view model
     */
    private fun setupObserver() {
        lifecycleScope.launchWhenStarted { viewModel.viewState.collect { setViewState(it) } }
    }

    private fun setViewState(it: SelectionViewStates) {
        when(it){
            is SelectionViewStates.MigrationSuccessful -> showToast(resources.getString(R.string.m_success))
        }
    }
}