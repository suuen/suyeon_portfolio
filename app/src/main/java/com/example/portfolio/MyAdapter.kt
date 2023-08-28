package com.example.portfolio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.portfolio.databinding.Type1Binding
import com.example.portfolio.databinding.Type2Binding

class MyAdapter(private val dataList: List<MyPhoneData>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    companion object { // 즐겨찾기 여부 상수
        private const val VIEW_TYPE_TYPE1 = 0
        private const val VIEW_TYPE_TYPE2 = 1
    }

    interface ItemClick {  // 리사이클 뷰의 아이템이 클릭되었을때 호출할 메서드
        fun onClick(view : View, position : Int)
    }

    var itemClick : ItemClick? = null // 아이템 클릭 이벤트를 처리할 콜백 변수

    // viewType에 따라 다른 뷰 홀더를 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder { // 뷰 홀더를 생성하는 메소드

        var view : View
        return when (viewType) { // 뷰 타입에 따른 다른 뷰 생성
            VIEW_TYPE_TYPE1 -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.type1, parent, false)
                Type1ViewHolder(view)
            }
            VIEW_TYPE_TYPE2 -> {
                val view =  LayoutInflater.from(parent.context).inflate(R.layout.type2, parent, false)
                Type2ViewHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) { // 뷰 홀더와 데이터를 바인딩하는 메소드

        holder.itemView.setOnClickListener { // 클릭 이벤트 실행
            itemClick?.onClick(it, position) //position 데이터 목록에서 현재 아이템의 위치
        }

        when (holder) {
            is Type1ViewHolder -> holder.bindType1(dataList[position])
            is Type2ViewHolder -> holder.bindType2(dataList[position])
        }


    }

    // 데이터 아이템의 개수를 반환
    override fun getItemCount(): Int {
        return dataList.size // 데이터 아이템의 총 개수를 반환하는 메소드
    }

    // position에 따라 viewType을 반환
    override fun getItemViewType(position: Int): Int { // 아이템의 위치에 따라 보여줄 뷰 홀더의 유형을 결정

        return if (dataList[position].aFavorites) {
            VIEW_TYPE_TYPE1 // 즐겨찾기된 연락처
        } else {
            VIEW_TYPE_TYPE2 // 즐겨찾기되지 않은 연락처
        }
    }

    // 뷰 홀더 클래스 정의
    inner class  Type1ViewHolder(view:View) : RecyclerView.ViewHolder(view) {

        val image = view.findViewById<ImageView>(R.id.iconItem)
        val name = view.findViewById<TextView>(R.id.textItem1)
        val number = view.findViewById<TextView>(R.id.textItem)
        fun bindType1(data: MyPhoneData) {
            image.setImageResource(data.aIcon)
            name.text = data.aName
            number.text = data.aNumber
        }
    }

    inner class Type2ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.iconItem)
        val name = view.findViewById<TextView>(R.id.textItem1)
        val number = view.findViewById<TextView>(R.id.textItem)
        fun bindType2(data: MyPhoneData) {
            image.setImageResource(data.aIcon)
            name.text = data.aName
            number.text = data.aNumber
        }
    }
}
