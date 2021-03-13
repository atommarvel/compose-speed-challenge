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
package com.example.androiddevchallenge.ui.screen2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Password
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.Home
import com.example.androiddevchallenge.LocalNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.common.MyButton
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.white

@Composable
fun LoginRoot() {
    val navController = LocalNavController.current
    Login { navController.navigate(Home) }
}

@Composable
fun Login(onNavToNextScreen: () -> Unit = {}) {
    Surface(
        Modifier.fillMaxSize()
    ) {
        Column {
            Box(contentAlignment = Alignment.TopCenter) {
                val res = R.drawable.ic_login_bg
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterResource(res),
                    contentScale = ContentScale.FillWidth,
                    contentDescription = null
                )

                Text(
                    modifier = Modifier.paddingFromBaseline(152.dp),
                    text = "Welcome\nback",
                    style = MaterialTheme.typography.h2,
                    color = white,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
            LoginTextField(hint = "Email Address", icon = Icons.Default.MailOutline)
            Spacer(modifier = Modifier.height(8.dp))
            LoginTextField(hint = "Password", icon = Icons.Default.Password)
            Spacer(modifier = Modifier.height(16.dp))
            MyButton(
                onClick = onNavToNextScreen,
                modifier = Modifier.padding(horizontal = 8.dp)
            ) {
                Text(text = "LOG IN")
            }
        }
    }
}

@Composable
fun LoginTextField(hint: String, icon: ImageVector) {
    OutlinedTextField(
        value = hint,
        onValueChange = { /*TODO*/ },
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    )
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        Login()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        Login()
    }
}
