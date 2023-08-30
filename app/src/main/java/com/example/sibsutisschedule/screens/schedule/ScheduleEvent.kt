package com.example.sibsutisschedule.screens.schedule

sealed interface ScheduleEvent {

    data class WeekDayChanged(val weekDay : String) : ScheduleEvent
}