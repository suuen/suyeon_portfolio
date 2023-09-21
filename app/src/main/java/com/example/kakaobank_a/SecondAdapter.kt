package com.example.kakaobank_a

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kakaobank_a.Utils.getDateFromTimestampWithFormat
import com.example.kakaobank_a.databinding.ItemBinding
import okhttp3.internal.notifyAll
import java.text.SimpleDateFormat

class SecondAdapter(var mContext: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


        var items = mutableListOf<data>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
            val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ItemViewHolder(binding)
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

            Glide.with(mContext)
                .load(items[position].url)
                .into((holder as ItemViewHolder).image)

            val inputDate = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
            val outputDate = SimpleDateFormat("yyyy-MM-dd HH:mm")

            val dataparse = inputDate.parse(items[position].date)
            val dataSimple = outputDate.format(dataparse)


            holder.title.text = items[position].name
            holder.like.visibility = View.GONE
            holder.date.text = dataSimple
        }

        override fun getItemCount(): Int {
            return items.size
        }


        inner class ItemViewHolder(binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
            var image: ImageView = binding.image
            var like: ImageView = binding.heart
            var title: TextView = binding.title
            var date: TextView = binding.date
            var item: ConstraintLayout = binding.items

            init {
                like.visibility = View.GONE

                // 아이템 클릭 리스너 설정
                item.setOnClickListener {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        items.removeAt(position)
                        notifyItemRemoved(position)
                    }
                }
            }
        }

    }
