package com.example.portfolio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.portfolio.databinding.Type1Binding
import com.example.portfolio.databinding.Type2Binding

class MyAdapter(private val dataList: List<MyPhoneData>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    companion object {
        private const val VIEW_TYPE_TYPE1 = 1
        private const val VIEW_TYPE_TYPE2 = 2
    }

    interface ItemClick {
        fun onClick(view : View, position : Int)
    }

    var itemClick : ItemClick? = null

    // viewType에 따라 다른 뷰 홀더를 생성합니다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            VIEW_TYPE_TYPE1 -> {
                val binding = Type1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                Type1ViewHolder(binding)
            }
            VIEW_TYPE_TYPE2 -> {
                val binding = Type2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                Type2ViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    // viewType에 따라 다른 뷰 홀더를 바인딩합니다.
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.itemView.setOnClickListener {  //클릭이벤트추가부분
            itemClick?.onClick(it, position)
        }

        when (holder) {
            is Type1ViewHolder -> holder.bindType1(dataList[position])
            is Type2ViewHolder -> holder.bindType2(dataList[position])
        }


    }

    // 데이터 아이템의 개수를 반환합니다.
    override fun getItemCount(): Int {
        return dataList.size
    }

    // position에 따라 viewType을 반환합니다.
    override fun getItemViewType(position: Int): Int {
        return if (dataList[position].aFavorites) {
            VIEW_TYPE_TYPE1 // 즐겨찾기된 연락처
        } else {
            VIEW_TYPE_TYPE2 // 즐겨찾기되지 않은 연락처
        }
    }

    // ViewHolder 클래스 정의
    inner class Type1ViewHolder(private val binding: Type1Binding) : RecyclerView.ViewHolder(binding.root) {
        fun bindType1(data: MyPhoneData) {
            // Type1의 ViewHolder에 데이터를 바인딩하는 코드 작성
            // 예를 들어, binding.textItem1.text = data.aName
        }
    }

    inner class Type2ViewHolder(private val binding: Type2Binding) : RecyclerView.ViewHolder(binding.root) {
        fun bindType2(data: MyPhoneData) {
            // Type2의 ViewHolder에 데이터를 바인딩하는 코드 작성
            // 예를 들어, binding.textItem1.text = data.aName
        }
    }
}
