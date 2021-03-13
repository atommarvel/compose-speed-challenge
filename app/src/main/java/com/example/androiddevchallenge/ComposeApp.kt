/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
