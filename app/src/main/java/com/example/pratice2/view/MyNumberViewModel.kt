package com.example.pratice2.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

enum class ActionType{
    PLUS, MINUS
}

//데이터의 변경
// 뷰모델은 데이터의 변경사항을 알려주는 라이브 데이터를 가지고 있다
class MyNumberViewModel : ViewModel() {
    companion object{
        val TAG: String = "로그"
    }
    // 뮤터블 라이브데이터 - 수정 가능
    // 라이브 데이터 - 값 변경 불가능

    //내부에서 설정하는 자료형은 뮤터블로 변경 가능하도록 설정
    private val _currentValue = MutableLiveData<Int>()

    //변경되지 않는 데이터를 가져 올때 이름을 _ 언더스코어 없이 설정
    // 공개적으로 가져오는 데이터는 private 이 아닌 퍼블릭으로 외부에서도 접근이 가능하도록 설정
    // 하지만 값을 직접 라이브데이터에 설정하지 않고 뷰모델을 통해 가져올수 있도록 설정
    val currentValue :LiveData<Int>
        get() = _currentValue
    // 초기값 설정
    init {
        Log.d(TAG,"MyNumberViewModel - () called")
        _currentValue.value = 0
    }

    fun updateValue(actionType: ActionType, input : Int){
        when(actionType){
            ActionType.PLUS ->
                _currentValue.value = _currentValue.value?.plus(input)
            ActionType.MINUS ->
                _currentValue.value = _currentValue.value?.minus(input)
        }
    }

}