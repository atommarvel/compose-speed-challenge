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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.common.MyButton
import com.example.androiddevchallenge.ui.common.MyChip
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun HomeRoot() {
    Home()
}

@Composable
fun Home() {
    LazyColumn {
        item { TopNav() }
        item { BalanceUpdates() }
        item { Spacer(modifier = Modifier.height(32.dp)) }
        item { Transact() }
        item { Spacer(modifier = Modifier.height(16.dp)) }
        item { PurchaseTypes() }
        item { BigChart() }
    }
}

// TODO: align center
@Composable
fun TopNav() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .paddingFromBaseline(64.dp)
            .padding(horizontal = 16.dp),
    ) {
        Text(text = "ACCOUNT", modifier = Modifier.weight(1f))
        Text(text = "WATCHLIST", modifier = Modifier.weight(1f))
        Text(text = "ACCOUNT", modifier = Modifier.weight(1f))
    }
}

@Composable
fun BalanceUpdates() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Balance", Modifier.paddingFromBaseline(top = 32.dp))
        Text("$73,589.01", Modifier.paddingFromBaseline(top = 48.dp))
        Spacer(modifier = Modifier.height(24.dp))
        Text("+412.35 today", Modifier.paddingFromBaseline(top = 16.dp))
    }
}

@Composable
fun Transact() {
    MyButton(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text("TRANSACT")
    }
}

@Composable
fun PurchaseTypes() {
    val types =
        listOf("ETFs", "Stocks", "Funds", "ETFs", "Stocks", "Funds", "ETFs", "Stocks", "Funds")
    LazyRow {
        item {
            MyChip(onClick = { /*TODO*/ }, label = "Week", showTrailingIcon = true)
        }
        items(types) { type ->
            MyChip(onClick = { /*TODO*/ }, label = type)
        }
    }
}

@Composable
fun BigChart() {
    Image(
        painter = painterResource(R.drawable.ic_home_illos),
        contentDescription = "Drawable Example",
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    )
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        Home()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        Home()
    }
}
