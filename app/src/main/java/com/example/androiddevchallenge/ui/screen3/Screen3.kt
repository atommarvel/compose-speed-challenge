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
package com.example.androiddevchallenge.ui.screen3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.LocalNavController
import com.example.androiddevchallenge.Screen1Route
import com.example.androiddevchallenge.ui.ExampleComposables
import com.example.androiddevchallenge.ui.common.MyTextField
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun Screen3Root() {
    val navController = LocalNavController.current
    Screen3 { navController.navigate(Screen1Route) }
}

@Composable
fun Screen3(onNavToNextScreen: () -> Unit = {}) {
    val showExample = false
    if (showExample) {
        ExampleComposables(onNavToNextScreen)
    } else {
        Row(modifier = Modifier.fillMaxSize()) {
            Top()
            Content()
            Bottom()
        }
    }
}

@Composable
fun Top() {
    Column(
        modifier = Modifier
            .background(Color.Red)
            .padding(top = 40.dp, start = 16.dp, end = 16.dp)
    ) {
        MyTextField(showSearchIcon = true, hint = "Search")
    }
}

@Composable
fun Content() {
}

@Composable
fun Bottom() {
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        Screen3()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        Screen3()
    }
}
