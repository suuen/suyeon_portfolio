package com.example.example

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addbtn = findViewById<Button>(R.id.add)
        val deletebtn = findViewById<Button>(R.id.delete)

        addbtn.setOnClickListener{
            add()
        }
        deletebtn.setOnClickListener{
            delete()
        }
    }
    private fun add(){
        val add_fragment = supportFragmentManager.beginTransaction()
        val fragment = fragment()
        add_fragment.add(R.id.fragment, fragment, "Fragment Add")
        add_fragment.addToBackStack(null)
        add_fragment.commit()
    }

    private fun delete(){
        val fragmentManager = supportFragmentManager
        val fragment = fragmentManager.findFragmentByTag("Fragment Delete")
        if (fragment != null) {
            val remove_fragment = fragmentManager.beginTransaction()
            remove_fragment.remove(fragment)
            remove_fragment.commit()
        }
    }
}