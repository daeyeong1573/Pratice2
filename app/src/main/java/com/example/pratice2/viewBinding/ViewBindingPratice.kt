package com.example.pratice2.viewBinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pratice2.R
import com.example.pratice2.databinding.ActivityDataBindingBinding.inflate
import com.example.pratice2.databinding.ActivityDataWithLiveBinding.inflate
import com.example.pratice2.databinding.ActivityViewBindingPraticeBinding

class ViewBindingPratice : AppCompatActivity() {

    val vbinding by lazy { ActivityViewBindingPraticeBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //기존의 setContentView 삭제
        setContentView(vbinding.root)
        test()
    }

    fun test(){
        // binding 이 프로퍼티로 선언되어 있기 때문에 액티비티 전체에서 호출 가능
        // binding.위젯id.속성 = "값"
        vbinding.viewBTest.setText("뷰바인딩 성공")
    }

}