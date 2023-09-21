package com.example.kakaobank_a

import android.util.Log
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date


object Utils {

    fun getDateFromTimestampWithFormat(
        timestamp: String?,
        fromFormatformat: String?,
        toFormatformat: String?
    ): String {
        var date: Date? = null
        var res = ""
        try {
            val format = SimpleDateFormat(fromFormatformat)
            date = format.parse(timestamp)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        val df = SimpleDateFormat(toFormatformat)
        res = df.format(date)
        return res
    }

}