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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.LocalNavController
import com.example.androiddevchallenge.LocalSysUiController
import com.example.androiddevchallenge.Login
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.common.MyButton
import com.example.androiddevchallenge.ui.common.MyButtonSecondary
import com.example.androiddevchallenge.ui.common.MyButtonText
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.insets.navigationBarsPadding

@Composable
fun WelcomeRoot() {
    val navController = LocalNavController.current
    val sysUiController = LocalSysUiController.current
    val colors = MaterialTheme.colors
    SideEffect {
        sysUiController.setSystemBarsColor(
            color = colors.surface.copy(alpha = 0.0f),
            darkIcons = false,
        )
    }
    WelcomeWeTrade { navController.navigate(Login) }
}

@Composable
fun WelcomeWeTrade(onNavToNextScreen: () -> Unit = {}) {
    MyTheme {
        Surface(
            color = MaterialTheme.colors.background,
            modifier = Modifier.fillMaxSize(),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .navigationBarsPadding(),
                contentAlignment = Alignment.Center,
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_welcome_bg),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
                Image(
                    painter = painterResource(R.drawable.ic_logo),
                    contentDescription = null,
                )
                Column(
                    modifier = Modifier
                        .padding(PaddingValues(16.dp, 32.dp))
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Row {
                        MyButton(
                            onClick = onNavToNextScreen,
                            modifier = Modifier.weight(1f)
                        ) {
                            MyButtonText("Get Started")
                        }
                        Spacer(Modifier.width(8.dp))
                        MyButtonSecondary(
                            onClick = onNavToNextScreen,
                            modifier = Modifier.weight(1f)
                        ) {
                            MyButtonText("Log In")
                        }
                    }
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        WelcomeWeTrade()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        WelcomeWeTrade()
    }
}
