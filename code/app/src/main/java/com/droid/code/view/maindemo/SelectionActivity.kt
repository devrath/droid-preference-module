package com.droid.code.view.maindemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.droid.code.databinding.ActivitySelectionBinding
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
    }

    private fun initViewModel() { viewModel = ViewModelProvider(this).get(SelectionVm::class.java) }

    private fun setOnClickListeners() {
        binding.apply {
            btnSharedPrefsId.setOnClickListener { startPreferenceScreen() }
            btnMigrateId.setOnClickListener { initiateMigration() }
            btnDataStoreId.setOnClickListener { startDataStoreScreen() }
        }
    }

    private fun startPreferenceScreen() {
        startActivity<SharedPreferenceActivity>()
    }

    private fun initiateMigration() {

    }

    private fun startDataStoreScreen() {

    }
}