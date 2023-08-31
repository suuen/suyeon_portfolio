package com.example.portfolio

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.portfolio.databinding.DetailpageBinding
import java.text.DecimalFormat


class secondpage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding = DetailpageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val receivedData = intent.getParcelableExtra<MarketItems>("data")

        if (receivedData != null) {
            binding.titleb.text = receivedData.aTitle
            binding.detail.text = receivedData.aDetail
            binding.addressB.text = receivedData.aAddress
            binding.keyword.text = receivedData.aKeyword

            val formatprice = DecimalFormat("#,###,### 원")
            val price = formatprice.format(receivedData.aPrice)
            binding.priceB.text = price
            binding.iconB.setImageResource(receivedData.aIcon)

            val backpageButton = findViewById<ImageView>(R.id.back_page)

            backpageButton.setOnClickListener{

                super.onBackPressed() // 뒤로가기 버튼
            }


        }


    }
}
