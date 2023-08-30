package com.example.portfolio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.portfolio.databinding.MainpageBinding
import java.text.DecimalFormat

class MyAdapter(val mItems: MutableList<MarketItems>) : RecyclerView.Adapter<MyAdapter.Holder>() {

    interface ItemClick {
        fun onClick(view : View, position : Int)
    }

    var itemClick : ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = MainpageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {  //클릭이벤트추가부분
            itemClick?.onClick(it, position)
        }
        holder.iconImageView.setImageResource(mItems[position].aIcon)
        holder.title.text = mItems[position].aTitle

        val formatprice = DecimalFormat("#,###,###").format(mItems[position].aPrice)
        holder.price.text = "${formatprice} 원"

        holder.address.text = mItems[position].aAddress
        holder.like.text = mItems[position].aLike.toString()
        holder.talk.text = mItems[position].aMessage.toString()
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    inner class Holder(val binding: MainpageBinding) : RecyclerView.ViewHolder(binding.root) {
        val iconImageView = binding.icon
        val title = binding.atitle
        val price = binding.price
        val address = binding.address
        val talk = binding.message
        val like = binding.like
    }
}