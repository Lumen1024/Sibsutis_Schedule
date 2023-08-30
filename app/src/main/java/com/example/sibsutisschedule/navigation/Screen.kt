package com.example.sibsutisschedule.navigation

// todo : nav args
sealed class Screen(val route: String) {
    object Splash : Screen(route = "splash")
    object Welcome : Screen(route = "welcome")
    object Schedule : Screen(route = "schedule")
    object Settings : Screen(route = "settings")
}