package com.example.sibsutisschedule.screens.schedule

import java.time.LocalDate

data class WeekDayWithDate(
    var isSelected: Boolean = false,
    val dayName: String = "",
    val dayNumber: LocalDate = LocalDate.now()
)