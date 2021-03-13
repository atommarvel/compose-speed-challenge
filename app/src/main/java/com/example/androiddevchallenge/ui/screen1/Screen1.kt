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
package com.example.androiddevchallenge.ui.screen1

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.LocalNavController
import com.example.androiddevchallenge.Screen2Route
import com.example.androiddevchallenge.ui.ExampleComposables
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun Screen1Root() {
    val navController = LocalNavController.current
    Screen1 { navController.navigate(Screen2Route) }
}

@Composable
fun Screen1(onNavToNextScreen: () -> Unit = {}) {
    ExampleComposables(onNavToNextScreen)
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        Screen1()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        Screen1()
    }
}
