package com.example.sibsutisschedule.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sibsutisschedule.screens.settings.SettingsScreen
import com.example.sibsutisschedule.screens.splash.SplashScreen
import com.example.sibsutisschedule.screens.welcome.WelcomeScreen
import com.example.sibsutisschedule.screens.welcome.WelcomeState
import com.example.sibsutisschedule.screens.welcome.WelcomeViewModel

@Composable
fun MainNavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Welcome.route) {

        composable(route = Screen.Splash.route) {
            SplashScreen()
        }

        composable(route = Screen.Welcome.route) {
            val viewModel = hiltViewModel<WelcomeViewModel>()
            viewModel.navHostController = navController

            val state by viewModel.state.collectAsState(WelcomeState())
            WelcomeScreen(state, viewModel::onEvent)
        }

        //todo : done navigation

        composable(route = Screen.Schedule.route) {

        }

        composable(route = Screen.Settings.route) {
            SettingsScreen(hiltViewModel(), navController)
        }
    }
}