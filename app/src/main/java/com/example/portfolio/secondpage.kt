package com.example.portfolio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.portfolio.databinding.DetailpageBinding

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
            binding.priceB.text = receivedData.aPrice.toString()
            binding.iconB.setImageResource(receivedData.aIcon)


        }
    }
}
