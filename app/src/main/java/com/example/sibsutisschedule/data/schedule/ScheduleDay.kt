package com.example.sibsutisschedule.data.schedule

data class ScheduleDay (
    val dayName: String,
    val lessons: List<Lesson> = emptyList()
)