package com.example.kakaobank_a

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.kakaobank_a.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.run {
            btn.setOnClickListener{
                setFragment(Fragment_first())
            }// 프레그먼트 1로 이동
            btn2.setOnClickListener{
                setFragment(Fragment_second())
            }// 프레그먼트 2로 이동
        }

        setFragment(Fragment_first())
    }

    private fun setFragment(fragment : Fragment){
        supportFragmentManager.commit {
            replace(R.id.frameLayout, fragment)
            setReorderingAllowed(true)
            addToBackStack(null)
        }
    }

}