package com.example.sibsutisschedule.data.schedule

data class ScheduleBlock(
    val firstWeek: List<ScheduleDay> = emptyList(),
    val secondWeek: List<ScheduleDay> = emptyList()
)