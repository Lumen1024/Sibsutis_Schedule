package com.example.sibsutisschedule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.sibsutisschedule.navigation.MainNavGraph
import com.example.sibsutisschedule.ui.theme.SibsutisScheduleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SibsutisScheduleTheme {
                navController = rememberNavController()
                MainNavGraph(navController)
            }
        }
    }
}