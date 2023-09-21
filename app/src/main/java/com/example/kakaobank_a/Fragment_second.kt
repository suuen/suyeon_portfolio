package com.example.kakaobank_a

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kakaobank_a.databinding.FragmentSecondBinding



class Fragment_second : Fragment() {

    private lateinit var SearchContext: Context
    private lateinit var binding: FragmentSecondBinding
    private lateinit var adapter: SecondAdapter

    private var likedItems: List<data> = listOf()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        SearchContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSecondBinding.inflate(inflater, container, false)
        adapter = SecondAdapter(SearchContext).apply {
            items = likedItems.toMutableList()
            return binding.root
        }


        binding = FragmentSecondBinding.inflate(inflater, container, false).apply {
            val spanCount = 2
            val layoutManager = GridLayoutManager(SearchContext, spanCount)
            binding.recycleBook.layoutManager = layoutManager
        }

        return binding.root
    }

}