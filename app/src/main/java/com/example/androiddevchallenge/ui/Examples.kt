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
package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.common.MyButton

@Composable
fun ExampleComposables(onNavToNextScreen: () -> Unit) {
    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ThemeDetectionExample()
            Spacer(modifier = Modifier.height(8.dp))
            UnderlinedTextExample()
            Spacer(modifier = Modifier.height(8.dp))
            DrawableExample()
            Spacer(modifier = Modifier.height(8.dp))
            MaterialIconExample()
            Spacer(modifier = Modifier.height(8.dp))
            NavigationExample(onNavToNextScreen)
        }
    }
}

@Composable
fun ThemeDetectionExample() {
    val themeType = if (MaterialTheme.colors.isLight) "light" else "dark"
    Text(
        text = "We are currently in $themeType theme",
        style = MaterialTheme.typography.h1
    )
}

@Composable
fun UnderlinedTextExample() {
    val underline = SpanStyle(textDecoration = TextDecoration.Underline)
    Text(
        text = buildAnnotatedString {
            append("This is how you ")
            pushStyle(underline) // apply underline to text appended after this
            append("underline")
            pop() // stop applying underline to text appended after this
            append(" text in a string using AnnotatedString!")
        },
        textAlign = TextAlign.Center,
        modifier = Modifier.paddingFromBaseline(24.dp) // This is important! The design spec uses distances from text baselines often.
    )
}

@Composable
fun DrawableExample() {
    val res =
        if (MaterialTheme.colors.isLight) R.drawable.ic_light_logo else R.drawable.ic_dark_logo
    Image(painter = painterResource(res), contentDescription = "Drawable Example")
}

/**
 * If you need an icon from Material design. It's likely obtainable this way.
 */
@Composable
fun MaterialIconExample() {
    Icon(imageVector = Icons.Default.Home, contentDescription = "Home Icon Example")
}

@Composable
fun NavigationExample(onNavToNextScreen: () -> Unit) {
    MyButton(
        onClick = onNavToNextScreen
    ) {
        Text(text = "Navigate to next screen")
    }
}
