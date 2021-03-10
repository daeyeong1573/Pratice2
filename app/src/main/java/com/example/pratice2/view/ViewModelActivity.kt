package com.example.pratice2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pratice2.R
import kotlinx.android.synthetic.main.activity_view_model.*

class ViewModelActivity : AppCompatActivity(), View.OnClickListener {

    companion object{
        val TAG: String = "로그"
    }

    //나중에 값이 설정될거라고 lateinit으로 설정
    lateinit var myNumberViewModel: MyNumberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)

        myNumberViewModel = ViewModelProvider(this).get(MyNumberViewModel::class.java)

        myNumberViewModel.currentValue.observe(this, Observer{
            Log.d(TAG,"ViewModelActivity - MynumberViewModel - currentValue 라이브 데이터 값 변경 : $it")
            number_textView.text = it.toString()
        })
        add_btn_viewmodel.setOnClickListener(this)
        minus_btn_viewmodel.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val userInput = input_edit_view.text.toString().toInt()

        //뷰모델에 라이브데이터 값을 변경하는 메소드 실행
        when(view){
            add_btn_viewmodel ->
                myNumberViewModel.updateValue(actionType = ActionType.PLUS, input = userInput)
            minus_btn_viewmodel ->
                myNumberViewModel.updateValue(actionType = ActionType.MINUS, input = userInput)
        }

    }
}