package com.example.example

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class fragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Fragment","onCreat")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        Log.d("Fragment","onCreatView")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Fragment","onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Fragment","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Fragment","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Fragment","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Fragment","onStop")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("Fragment","onSaveInstanceState")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("Fragment","onDestoryView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Fragment","onDestory")
    }
}

