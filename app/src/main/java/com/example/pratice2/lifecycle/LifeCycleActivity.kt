package com.example.pratice2.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import com.example.pratice2.R
import com.example.pratice2.databinding.ActivityLifeCycleBinding

class LifeCycleActivity : AppCompatActivity() {
    val TAG: String = "로그"
    val lbinding by lazy { ActivityLifeCycleBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //레이아웃 설정
        setContentView(lbinding.root)
        Log.d(TAG,"LifeCycleActivity - onCreate() called")
        lbinding.button.setOnClickListener {
            Toast.makeText(this,"버튼을 클릭하였습니다.",Toast.LENGTH_LONG).show()
        }


    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"LifeCycleActivity - onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"LifeCycleActivity - onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"LifeCycleActivity - onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"LifeCycleActivity - onStop() called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"LifeCycleActivity - onRestart() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"LifeCycleActivity - onDestroy() called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG,"LifeCycleActivity - onSaveInstanceState() called")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG,"LifeCycleActivity - onRestoreInstanceState() called")
    }
}