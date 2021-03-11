package com.example.pratice2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import com.example.pratice2.databinding.ActivityDataWithLiveBinding

class DataWithLiveActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDataWithLiveBinding

    val liveText = MutableLiveData<String>()

    val TAG: String = "로그"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_with_live)

        binding = DataBindingUtil.setContentView<ActivityDataWithLiveBinding>(this,R.layout.activity_data_with_live)

        binding.apply {
            lifecycleOwner = this@DataWithLiveActivity
            dwl = this@DataWithLiveActivity

            btnChangeDwl.setOnClickListener {
                Log.d(TAG,"LiveData - LiveData called")
                liveText.value = "Hello Live data!"
            }


        }
        liveText.value = "Hello Data Binding!"

    }
}
