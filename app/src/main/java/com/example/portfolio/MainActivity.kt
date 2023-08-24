package com.example.portfolio

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.portfolio.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 데이터 원본 준비
        val dataList = mutableListOf<MyPhoneData>()
        dataList.add(MyPhoneData(R.drawable.sample_0, "신짱구", "010 - 1234 - 5678",true))
        dataList.add(MyPhoneData(R.drawable.sample_1, "봉미선", "010 - 2345 -6789",true))
        dataList.add(MyPhoneData(R.drawable.sample_2, "신형만", "010 - 3456 - 7890",true))
        dataList.add(MyPhoneData(R.drawable.sample_3, "김철수", "010 - 7654 - 3210",false))
        dataList.add(MyPhoneData(R.drawable.sample_4, "유 리", "010 - 1111 - 2222",false))
        dataList.add(MyPhoneData(R.drawable.sample_5, "맹 구", "010 - 2222 - 3333",false))
        dataList.add(MyPhoneData(R.drawable.sample_6, "훈 이", "010 - 3333 - 4444",false))
        dataList.add(MyPhoneData(R.drawable.sample_7, "이슬이", "010 - 4444 - 5555",true))
        dataList.add(MyPhoneData(R.drawable.sample_8, "흑곰", "010 - 6666 - 7777",false))
        dataList.add(MyPhoneData(R.drawable.sample_9, "오수", "010 - 7777 - 8888",false))
        dataList.add(MyPhoneData(R.drawable.sample_10, "수지", "010 - 8888 - 9999",false))


        binding.recyclerView.adapter = MyAdapter(dataList)

        val adapter = MyAdapter(dataList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)



        adapter.itemClick = object : MyAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val number: String = dataList[position].aNumber
                val myIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${number}"))
                startActivity(myIntent)
            }
        }
    }
}