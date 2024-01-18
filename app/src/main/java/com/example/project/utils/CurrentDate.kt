package com.example.project.utils

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month


class CurrentDate {
    private val currentDate: LocalDate = LocalDate.now()
    val currentMonth = when(currentDate.month) {
        Month.JANUARY -> "01"
        Month.FEBRUARY -> "02"
        Month.MARCH -> "03"
        Month.APRIL -> "04"
        Month.MAY -> "05"
        Month.JUNE -> "06"
        Month.JULY -> "07"
        Month.AUGUST -> "08"
        Month.SEPTEMBER -> "09"
        Month.OCTOBER -> "10"
        Month.NOVEMBER -> "11"
        Month.DECEMBER -> "12"
    }

    private val currentDayOfWeek: DayOfWeek = currentDate.dayOfWeek
    val dayOfWeekString: String = currentDayOfWeek.getDisplayName(
        java.time.format.TextStyle.FULL,
        java.util.Locale.getDefault()
    )

    val currentYear: Int = currentDate.year

    private val daysUntilMonday = (DayOfWeek.MONDAY.value - currentDayOfWeek.value - 7) % 7
    val startDate = currentDate.plusDays(daysUntilMonday.toLong())
    val endDate = startDate.plusDays(6)

    val currentDayOfMonth = currentDate.dayOfMonth
}