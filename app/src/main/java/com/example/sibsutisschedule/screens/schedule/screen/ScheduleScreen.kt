package com.example.sibsutisschedule.screens.schedule.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.sibsutisschedule.screens.schedule.ScheduleEvent
import com.example.sibsutisschedule.screens.schedule.ScheduleState

// todo: refactor
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScheduleScreen(
    state: ScheduleState,
    onEvent: (ScheduleEvent) -> Unit
) {
    Scaffold() {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            //WeekDaySelectRow()
            //DaySchedule()
        }
    }
}

enum class MyColors(val color: Color) {
    Red(Color.Red), Green(Color.Green), Blue(Color.Blue)
}
