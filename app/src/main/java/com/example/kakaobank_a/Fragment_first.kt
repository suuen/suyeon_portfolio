package com.example.kakaobank_a

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kakaobank_a.databinding.FragmentFirstBinding
import com.example.kakaobank_a.retrofit_client.apiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Fragment_first : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var SearchContext: Context
    private lateinit var adapter: FirstAdapter

    private var resItems: ArrayList<data> = ArrayList()


    override fun onAttach(context: Context) {
        super.onAttach(context)
        SearchContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)

        setupView()
        setupListener()
        Log.d("onCreate 확인","check")
        return binding.root
    }

    private fun setupView() {
        // GridLayoutManager 설정

        val myLayoutManager = GridLayoutManager(SearchContext, 2)
        binding.recycleview.layoutManager = myLayoutManager

        adapter = FirstAdapter(SearchContext)
        binding.recycleview.adapter = adapter  // RecyclerView에 어댑터 연결
        binding.recycleview.itemAnimator = null
    }


    private fun setupListener() {
        val searchButton = binding.searchBtn
        val searchText = binding.searchText

        searchButton.setOnClickListener {
            Log.d("click 확인","click")
            val query = searchText.text.toString()
            if (query.isNotEmpty()) {
                adapter.clearItem()
                fetchImageResults(query)
            }
        }
    }





    private fun fetchImageResults(query: String) {

        adapter.clearItem()

        apiService.imagedata(Constants.AUTH_HEADER, query, "recency", 1, 80)
            .enqueue(object : Callback<ImageModel> {
                override fun onResponse(call: Call<ImageModel>, response: Response<ImageModel>) {
                    response.body()?.meta?.let { meta ->
                        if (meta.totalCount > 0) {
                            response.body()!!.documents.forEach { document ->
                                val title = document.displaySitename
                                val datetime = document.datetime
                                val url = document.thumbnailUrl
                                resItems.add(data(title, datetime, url))
                            }
                        }
                        adapter.items = resItems
                        adapter.notifyDataSetChanged()
                    }

                }

                override fun onFailure(call: Call<ImageModel>, t: Throwable) {
                    Log.e("log_check", " ${t.message}")
                }
            })
    }
}
