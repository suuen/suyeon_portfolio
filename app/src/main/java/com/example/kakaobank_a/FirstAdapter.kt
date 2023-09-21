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
import com.example.kakaobank_a.databinding.ItemBinding

class FirstAdapter(private val mContext: Context) : RecyclerView.Adapter<FirstAdapter.ItemViewHolder>() {

    var items = ArrayList<data>()

    fun clearItem() {
        items.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = items[position]

        Glide.with(mContext)
            .load(currentItem.url)
            .into(holder.image)

        holder.title.text = currentItem.name
        holder.date.text = currentItem.date


        holder.image.setOnClickListener {
            val item = items[position]
            item.like = !item.like // 클릭할 때마다 상태를 토글합니다.

            if (item.like) {
                holder.like.visibility = View.VISIBLE
                (mContext as MainActivity).addlike(item)
            } else {
                holder.like.visibility = View.GONE
                (mContext as MainActivity).deletelike(item)
            }
        }
    }

    override fun getItemCount() = items.size

    inner class ItemViewHolder(binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        var image: ImageView = binding.image
        var like: ImageView = binding.heart
        var title: TextView = binding.title
        var date: TextView = binding.date
        var item: ConstraintLayout = binding.items
    }
}
