package com.example.sibsutisschedule.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sibsutisschedule.screens.settings.SettingsScreen
import com.example.sibsutisschedule.screens.splash.SplashScreen
import com.example.sibsutisschedule.screens.welcome.WelcomeScreen

@Composable
fun MainNavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Welcome.route) {

        composable(route = Screen.Splash.route) {
            SplashScreen()
        }

        composable(route = Screen.Welcome.route) {
            WelcomeScreen(navController)
        }

        //todo : done navigation

        composable(route = Screen.Schedule.route) {

        }

        composable(route = Screen.Settings.route) {
            SettingsScreen(hiltViewModel(), navController)
        }
    }
}