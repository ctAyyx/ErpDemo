package com.ct.utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

object TimeUtils {

    private const val pattern01 = "yyyy-MM-dd'T'HH:mm:ss"


    private val format01: SimpleDateFormat by lazy {
        SimpleDateFormat(pattern01, Locale.getDefault())
    }
    private val calendar01: Calendar by lazy {
        Calendar.getInstance()
    }


    fun getFormatTimeBy01(year: Int, month: Int, day: Int, hour: Int, minute: Int): String {
        calendar01.set(year, month, day, hour, minute, 0)
        return format01.format(calendar01.time)
    }

}