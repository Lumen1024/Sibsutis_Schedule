package com.example.sibsutisschedule.data.schedule

// todo : replace type String of some fields
data class Lesson(
    val startTime : String,
    val endTime : String,
    val name : String,
    val lessonType : String,
    val teacher : String,
    val location : String
)