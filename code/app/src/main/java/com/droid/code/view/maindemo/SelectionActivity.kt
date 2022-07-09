package com.droid.code.view.maindemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.code.R
import com.droid.code.databinding.ActivitySelectionBinding
import com.droid.code.utils.showToast
import com.droid.code.utils.startActivity
import com.droid.code.view.dataStore.DataStoreActivity
import com.droid.code.view.sharedPreference.SharedPreferenceActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SelectionActivity : AppCompatActivity()  {

    private lateinit var binding: ActivitySelectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.apply {
            btnSharedPrefsId.setOnClickListener { startActivity<SharedPreferenceActivity>() }
            btnDataStoreId.setOnClickListener { startActivity<DataStoreActivity>() }
        }
    }
    
}