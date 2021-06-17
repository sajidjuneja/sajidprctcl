package com.wmt.sajid.utils

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class Utils {
    companion object{
        @SuppressLint("SimpleDateFormat")
        fun convertToNewFormat(dateStr: String): String? {
            val utc = TimeZone.getTimeZone("UTC")
            val sourceFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            val destFormat = SimpleDateFormat("dd/MM/yyyy")
            sourceFormat.timeZone = utc
            val convertedDate: Date = sourceFormat.parse(dateStr)
            return destFormat.format(convertedDate)
        }
    }
}