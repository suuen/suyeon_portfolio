package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.TitleFragmentBinding

class TitleFragment : Fragment() {
    private lateinit var binding: TitleFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = TitleFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        val newsData = NewsData()
        val adapter = MainAdapter(newsData)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        adapter.itemClick = object : MainAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val selectedItem = newsData[position]
                val detailFragment = DetailFragment()
                val bundle = Bundle()
                bundle.putString("articleDetail", selectedItem.content)
                detailFragment.arguments = bundle

                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.detail, detailFragment)
                    .addToBackStack(null)
                    .commit()
            }
        }
        return view
    }

    private fun NewsData(): List<NewsItem> {
        // 데이터 원본
        return listOf(
            NewsItem(
                R.drawable.ai,"기사 제목","기사 내용", "2023.09.10","김기자", "중앙일보"),
            NewsItem(
                R.drawable.ai,"기사 제목","냠냠 내용", "2023.09.10","김기자", "중앙일보"),
            NewsItem(
                R.drawable.ai,"기사 제목","기사 내용", "2023.09.10","김기자", "중앙일보"),
            NewsItem(
                R.drawable.ai,"기사 제목","기사 내용", "2023.09.10","김기자", "중앙일보"),)

    }

}