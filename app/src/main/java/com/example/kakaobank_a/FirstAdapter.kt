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

class FirstAdapter(private val mContext: Context): RecyclerView.Adapter<FirstAdapter.ItemViewHolder>() {

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
    }

    override fun getItemCount() = items.size

    inner class ItemViewHolder(binding:ItemBinding ) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        var image: ImageView = binding.image
        var like: ImageView = binding.heart
        var title: TextView = binding.title
        var date: TextView = binding.date
        var item: ConstraintLayout = binding.items

        init {


            like.visibility = View.GONE


            item.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    items.removeAt(position)
                    notifyItemRemoved(position)
                }
            }
        }

        override fun onClick(p0: View?) {
            TODO("Not yet implemented")
        }

    }

}