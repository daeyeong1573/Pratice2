package com.example.pratice2.liveData

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.pratice2.R
import com.example.pratice2.databinding.ActivityLiveDataBinding

class LiveData : AppCompatActivity() {
    val LiveBinding by lazy { ActivityLiveDataBinding.inflate(layoutInflater) }
    private var ctn = 0

    // value값 초기화
    private var livetext : MutableLiveData<String> = MutableLiveData<String>().apply {
        value = "Hello world ${++ctn}"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(LiveBinding.root)

        //live data의 value의 변경을 감지하고 호출
        livetext.observe(this, Observer {

            //it으로 넘어오는 param은 LiveData의 value
               LiveBinding.textTest.text = it
        })

        LiveBinding.btnChange.setOnClickListener {

            //livetext의 value를 변경
            //livetext 자체를 변경하면 안됨
            livetext.value = "Hello world ${++ctn}"
        }

    }
}