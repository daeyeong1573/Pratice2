package com.example.pratice2.dataBindg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.pratice2.R
import com.example.pratice2.databinding.ActivityDataBindingBinding

class DataBindingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDataBindingBinding

    var text = "TEST"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_binding)
        binding = DataBindingUtil.setContentView<ActivityDataBindingBinding>(this,R.layout.activity_data_binding)

        binding.test = this
        binding.button2.setOnClickListener {
            text = "TEST2"
            binding.invalidateAll()
        }
    }
}

