package com.example.sibsutisschedule.screens.schedule.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.sibsutisschedule.data.schedule.Lesson

// todo: refactor
@Composable
fun DaySchedule(lessons : List<Lesson>) {
    LazyColumn() {
        items(lessons) {
            LessonItem(lesson = it)
        }
    }
}


// todo : make LessonItem beauty
@Composable
fun LessonItem(lesson: Lesson) {
    Card() {
        Row() {
            Column {
                Text(text = lesson.startTime)
                Text(text = lesson.endTime)
            }
            Text(text = lesson.name)
            Text(text = lesson.location)
            Text(text = lesson.teacher)
            Text(text = lesson.lessonType)
        }
    }
}