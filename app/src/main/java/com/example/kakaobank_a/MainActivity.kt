package com.example.kakaobank_a

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kakaobank_a.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.run {
            btn.setOnClickListener{

            }// 프레그먼트 1로 이동
            btn2.setOnClickListener{

            }// 프레그먼트 2로 이동
        }


    }
}