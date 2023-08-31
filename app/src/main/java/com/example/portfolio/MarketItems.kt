
package com.example.portfolio

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MarketItems(
    val aIcon : Int,val aTitle : String, val aDetail : String,val aKeyword : String , val aPrice : Int , val aAddress : String,val aLike: Int , val aMessage : Int
) : Parcelable
    // Parcelable 구현

