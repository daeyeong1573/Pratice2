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


    var text = "TEST"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_binding)
        //바인딩 세팅
       val binding = DataBindingUtil.setContentView<ActivityDataBindingBinding>(this,R.layout.activity_data_binding)
        // 현재 binding시킨 xml의 variable name
        binding.test = this
        binding.button2.setOnClickListener {
            text = "바인딩 성공"
            Toast.makeText(this,"바인딩 성공",Toast.LENGTH_SHORT).show()
            // Data가 변동될 경우 binding된 View들에 Data 변화를 알려줌
            binding.invalidateAll()
        }
    }
}

