package com.example.portfolio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.portfolio.databinding.Type1Binding
import com.example.portfolio.databinding.Type2Binding

class MyAdapter(private val dataList: List<MyPhoneData>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_TYPE1 = 0
        private const val VIEW_TYPE_TYPE2 = 1
    }

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            VIEW_TYPE_TYPE1 -> {
                val binding = Type1Binding.inflate(inflater, parent, false)
                ViewHolder.Type1ViewHolder(binding)
            }
            VIEW_TYPE_TYPE2 -> {
                val binding = Type2Binding.inflate(inflater, parent, false)
                ViewHolder.Type2ViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }

        when (holder) {
            is ViewHolder.Type1ViewHolder -> holder.bindType1(dataList[position])
            is ViewHolder.Type2ViewHolder -> holder.bindType2(dataList[position])
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (dataList[position].aFavorites) {
            VIEW_TYPE_TYPE1
        } else {
            VIEW_TYPE_TYPE2
        }
    }

    sealed class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        class Type1ViewHolder(val binding: Type1Binding) : ViewHolder(binding.root) {
            fun bindType1(data: MyPhoneData) {
                binding.iconItem.setImageResource(data.aIcon)
                binding.textItem1.text = data.aName
                binding.textItem.text = data.aNumber
            }
        }

        class Type2ViewHolder(val binding: Type2Binding) : ViewHolder(binding.root) {
            fun bindType2(data: MyPhoneData) {
                binding.iconItem.setImageResource(data.aIcon)
                binding.textItem1.text = data.aName
                binding.textItem.text = data.aNumber
            }
        }
    }
}
