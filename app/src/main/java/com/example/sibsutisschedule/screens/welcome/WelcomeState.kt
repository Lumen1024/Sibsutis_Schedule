package com.example.sibsutisschedule.screens.welcome

import com.example.sibsutisschedule.data.group.Group

data class WelcomeState(
    var groupName: String = "",
    val groups : List<Group> = emptyList()
)