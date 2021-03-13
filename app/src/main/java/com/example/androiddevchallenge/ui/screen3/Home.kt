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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Divider
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.common.MyButton
import com.example.androiddevchallenge.ui.common.MyChip
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.green
import com.example.androiddevchallenge.ui.theme.red

@Composable
fun HomeRoot() {
    Home()
}

data class StockModel(
    val res: Int,
    val symbol: String,
    val name: String,
    val price: String,
    val change: String,
    val isChangePositive: Boolean
)

val stocks: List<StockModel> by lazy {
    mutableListOf<StockModel>().apply {
        repeat(10) {
            add(
                StockModel(
                    res = R.drawable.ic_home_alk,
                    symbol = "ALK",
                    name = "Alaska Air Group, Inc.",
                    price = "$7.918",
                    change = "-0.54%",
                    isChangePositive = false
                )
            )
        }
    }
}

@Composable
fun Home() {
    Surface(color = MaterialTheme.colors.background) {
        LazyColumn {
            item { TopNav() }
            item { BalanceUpdates() }
            item { Spacer(modifier = Modifier.height(32.dp)) }
            item { Transact() }
            item { Spacer(modifier = Modifier.height(16.dp)) }
            item { Chips() }
            item { Spacer(modifier = Modifier.height(16.dp)) }
            item { BigChart() }
            item { Spacer(modifier = Modifier.height(32.dp)) }
            item { PositionsHeader() }
            items(stocks) { model ->
                Stock(model)
            }
        }
    }
}

@Preview
@Composable
fun StockPreview() {
    MyTheme {
        Stock(stocks.first())
    }
}

@Composable
fun Stock(model: StockModel) {
    Surface {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        ) {
            Divider()
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    Text(
                        model.price,
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.paddingFromBaseline(top = 24.dp)
                    )
                    val changeColor = if (model.isChangePositive) green else red
                    Text(
                        model.change,
                        style = MaterialTheme.typography.body1.copy(color = changeColor),
                        modifier = Modifier.paddingFromBaseline(top = 16.dp)
                    )
                }
                Spacer(modifier = Modifier.width(24.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        model.symbol,
                        style = MaterialTheme.typography.h3,
                        modifier = Modifier.paddingFromBaseline(top = 24.dp)
                    )
                    Text(
                        model.name,
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.paddingFromBaseline(top = 16.dp)
                    )
                }
                Image(
                    painter = painterResource(model.res),
                    contentDescription = "Drawable Example",
                    modifier = Modifier.height(56.dp),
                    contentScale = ContentScale.Inside
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun TopNav() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .paddingFromBaseline(64.dp)
            .padding(horizontal = 16.dp),
    ) {
        Text(
            text = "ACCOUNT",
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.button
        )
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.disabled) {
            Text(
                text = "WATCHLIST",
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.button
            )
            Text(
                text = "PROFILE",
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.button
            )
        }
    }
}

@Composable
fun BalanceUpdates() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Balance",
            Modifier.paddingFromBaseline(top = 32.dp),
            style = MaterialTheme.typography.subtitle1
        )
        Text(
            "$73,589.01",
            Modifier.paddingFromBaseline(top = 48.dp),
            style = MaterialTheme.typography.h1
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            "+412.35 today",
            Modifier.paddingFromBaseline(top = 16.dp),
            style = MaterialTheme.typography.subtitle1.copy(color = green)
        )
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
fun Chips() {
    val types =
        listOf("ETFs", "Stocks", "Funds", "ETFs", "Stocks", "Funds", "ETFs", "Stocks", "Funds")
    LazyRow {
        item {
            Spacer(modifier = Modifier.width(16.dp))
            MyChip(onClick = { /*TODO*/ }, label = "Week", showTrailingIcon = true)
        }
        items(types) { type ->
            Spacer(modifier = Modifier.width(8.dp))
            MyChip(onClick = { /*TODO*/ }, label = type)
        }
        item {
            Spacer(modifier = Modifier.width(16.dp))
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

@Composable
fun PositionsHeader() {
    Surface {
        Text(
            text = "Positions",
            modifier = Modifier
                .paddingFromBaseline(40.dp)
                .padding(bottom = 24.dp)
                .fillMaxWidth(),
            style = MaterialTheme.typography.subtitle1,
            textAlign = TextAlign.Center
        )
    }
}

// @Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        Home()
    }
}

// @Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        Home()
    }
}
