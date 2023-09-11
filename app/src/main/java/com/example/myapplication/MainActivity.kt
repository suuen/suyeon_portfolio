package com.example.myapplication

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val direction = resources.configuration.orientation

        if (direction == Configuration.ORIENTATION_LANDSCAPE) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.title, TitleFragment())
                .replace(R.id.detail, DetailFragment())
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, TitleFragment())
                .commit()
        }
    }
}
