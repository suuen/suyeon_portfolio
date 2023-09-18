package com.example.example

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.d("SecondActivity", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("SecondActivity","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("SecondActivity","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("SecondActivity","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("SecondActivity","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SecondActivity","onDestory")
    }
}