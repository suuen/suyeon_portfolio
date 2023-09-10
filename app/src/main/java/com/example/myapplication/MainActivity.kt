package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import android.content.res.Configuration


class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val direction = resources.configuration.orientation

        if(direction == Configuration.ORIENTATION_LANDSCAPE) {
            supportFragmentManager.beginTransaction()
                .add(R.id.title, TitleFragment()).commit()
            supportFragmentManager.beginTransaction()
                .add(R.id.detail_context, DetailFragment()).commit()
        }

        else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, TitleFragment())
                .commit()
        }
    }
}