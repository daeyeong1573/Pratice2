package com.example.pratice2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pratice2.R
import com.example.pratice2.databinding.ActivityViewModelBinding

class ViewModelActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        val TAG: String = "로그"
    }

    val mBinding by lazy { ActivityViewModelBinding.inflate(layoutInflater) }

    //나중에 값이 설정될거라고 lateinit으로 설정
    lateinit var myNumberViewModel: MyNumberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)

        myNumberViewModel = ViewModelProvider(this).get(MyNumberViewModel::class.java)

        myNumberViewModel.currentValue.observe(this, Observer {
            Log.d(TAG, "ViewModelActivity - MynumberViewModel - currentValue 라이브 데이터 값 변경 : $it")
            mBinding.numberTextView.text = it.toString()
        })
        mBinding.addBtnViewmodel.setOnClickListener(this)
        mBinding.minusBtnViewmodel.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val userInput = mBinding.inputEditView.text.toString().toInt()

        //뷰모델에 라이브데이터 값을 변경하는 메소드 실행
        when (view) {
            mBinding.addBtnViewmodel ->
                myNumberViewModel.updateValue(actionType = ActionType.PLUS, input = userInput)
            mBinding.minusBtnViewmodel ->
                myNumberViewModel.updateValue(actionType = ActionType.MINUS, input = userInput)
        }

    }
}