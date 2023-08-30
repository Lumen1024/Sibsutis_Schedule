package com.example.sibsutisschedule.screens.welcome

import com.example.sibsutisschedule.data.group.Group

sealed interface WelcomeEvent {
    data class GroupNameChanged(val groupName : String) : WelcomeEvent
    data class GroupSelected(val group: Group) : WelcomeEvent
}