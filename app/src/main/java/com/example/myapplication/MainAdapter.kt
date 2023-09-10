package com.example.myapplication


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.RecycleTitleBinding

class MainAdapter(val mItems : List<NewsItem>) : RecyclerView.Adapter<MainAdapter.Holder>(){
    interface ItemClick {
        fun onClick(view : View, position: Int)
    }

    var itemClick : ItemClick? = null

    override fun onBindViewHolder(holder: MainAdapter.Holder, position: Int) {
        holder.img.setImageResource(mItems[position].image)
        holder.title.text = mItems[position].title
        holder.content.text = mItems[position].content
        holder.Date.text = mItems[position].data
        holder.company.text = mItems[position].company
        holder.name.text = mItems[position].name

        holder.itemView.setOnClickListener {
                view -> itemClick?.onClick(view, position)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.Holder {
        val binding = RecycleTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    inner class Holder( binding :RecycleTitleBinding ) : RecyclerView.ViewHolder(binding.root) {
        val img = binding.newsImage
        val title = binding.newsTitle
        val content = binding.newsContext
        val Date = binding.newsData
        val company = binding.newsCompany
        val name = binding.newsWrite
    }
}