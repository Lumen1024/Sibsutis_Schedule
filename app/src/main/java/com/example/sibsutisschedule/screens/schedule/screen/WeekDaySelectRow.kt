package com.example.sibsutisschedule.screens.schedule.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sibsutisschedule.screens.schedule.WeekDayWithDate

@Composable
fun WeekDaySelectRow(days: List<WeekDayWithDate>, onDaySelect: (WeekDayWithDate) -> Unit) {
    val scrollState = rememberScrollState()
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(scrollState),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(days) {
            WeekDayItem(day = it, onDaySelect)
        }
    }
}

// todo: make beauty
@Composable
fun WeekDayItem(day: WeekDayWithDate, onDaySelect: (WeekDayWithDate) -> Unit) {
    val backgroundColor =
        if (day.isSelected) MaterialTheme.colorScheme.primary
        else MaterialTheme.colorScheme.secondary

    Column(
        modifier = Modifier
            .background(backgroundColor)
            .fillMaxHeight()
            .width(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
//        Text
    }
}

@Preview(showBackground = true)
@Composable
fun WeekDaySelectRowPreview() {

    val days = listOf(
        WeekDayWithDate(dayName = "Понедельник"),
        WeekDayWithDate(dayName = "Вторник"),
        WeekDayWithDate(dayName = "Среда"),
        WeekDayWithDate(dayName = "Четверг"),
        WeekDayWithDate(dayName = "Пятница"),
        WeekDayWithDate(dayName = "Суббота"),
    )
    WeekDaySelectRow(days) {}
}
