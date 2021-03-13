package com.example.androiddevchallenge

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.screen1.Screen1Root
import com.example.androiddevchallenge.ui.screen2.Screen2Root
import com.example.androiddevchallenge.ui.screen3.Screen3Root
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

// Top level CompositionLocals
val LocalNavController = compositionLocalOf<NavHostController> { error("No NavController") }

// Screens in app
const val Screen1Route = "screen_1"
const val Screen2Route = "screen_2"
const val Screen3Route = "screen_3"
// Example screen navigation: LocalNavController.current.navigate(Screen1Route)

@Composable
fun ComposeApp(activity: Activity) {
    CompositionLocalProvider(
        LocalNavController provides rememberNavController(),
    ) {
        MyTheme {
            ProvideWindowInsets {
                NavHost(
                    navController = LocalNavController.current,
                    startDestination = Screen1Route
                ) {
                    composable(Screen1Route) { Screen1Root() }
                    composable(Screen2Route) { Screen2Root() }
                    composable(Screen3Route) { Screen3Root() }
                }
            }
        }
    }
}