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
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Divider
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.LocalSysUiController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.common.MyButton
import com.example.androiddevchallenge.ui.common.MyButtonText
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
        repeat(2) {
            add(
                StockModel(
                    res = R.drawable.ic_home_alk,
                    symbol = "ALK",
                    name = "Alaska Air Group, Inc.",
                    price = "$7,918",
                    change = "-0.54%",
                    isChangePositive = false
                )
            )
            add(
                StockModel(
                    res = R.drawable.ic_home_ba,
                    symbol = "BA",
                    name = "Boeing Co.",
                    price = "$1,293",
                    change = "+4.18%",
                    isChangePositive = true
                )
            )
            add(
                StockModel(
                    res = R.drawable.ic_home_dal,
                    symbol = "DAL",
                    name = "Delta Airlines Inc.",
                    price = "$893.50",
                    change = "-0.54%",
                    isChangePositive = false
                )
            )
            add(
                StockModel(
                    res = R.drawable.ic_home_exp,
                    symbol = "EXPE",
                    name = "Expedia Group, Inc.",
                    price = "$12,301",
                    change = "+2.51%",
                    isChangePositive = true
                )
            )
            add(
                StockModel(
                    res = R.drawable.ic_home_eadsy,
                    symbol = "EADSY",
                    name = "Airbus SE",
                    price = "$12,301",
                    change = "+1.38%",
                    isChangePositive = true
                )
            )
            add(
                StockModel(
                    res = R.drawable.ic_home_jblu,
                    symbol = "JBLU",
                    name = "Jetblue Airways Corp.",
                    price = "$8,521",
                    change = "+1.56%",
                    isChangePositive = true
                )
            )
            add(
                StockModel(
                    res = R.drawable.ic_home_mar,
                    symbol = "MAR",
                    name = "Marriott International Inc.",
                    price = "$521",
                    change = "+2.75%",
                    isChangePositive = true
                )
            )
            add(
                StockModel(
                    res = R.drawable.ic_home_ccl,
                    symbol = "CCL",
                    name = "Carnival Corp",
                    price = "$5,481",
                    change = "+0.14%",
                    isChangePositive = true
                )
            )
            add(
                StockModel(
                    res = R.drawable.ic_home_rcl,
                    symbol = "RCL",
                    name = "Royal Caribbean Cruises",
                    price = "$9,184",
                    change = "+1.69%",
                    isChangePositive = true
                )
            )
            add(
                StockModel(
                    res = R.drawable.ic_home_trvl,
                    symbol = "TRVL",
                    name = "Travelocity Inc.",
                    price = "$654",
                    change = "+3.23%",
                    isChangePositive = true
                )
            )
        }
    }
}

@Composable
fun Home() {
    val isLight = MaterialTheme.colors.isLight
    val (currentlyShowingDarkIcons, setcurrentlyShowingDarkIcons) = remember { mutableStateOf(false) }
    val listState = rememberLazyListState()
    Surface(color = MaterialTheme.colors.background) {
        LazyColumn(state = listState) {
            item { TopNav() }
            item { BalanceUpdates() }
            item { Spacer(modifier = Modifier.height(32.dp)) }
            item { Transact() }
            item { Spacer(modifier = Modifier.height(16.dp)) }
            item { Chips() }
            item { Spacer(modifier = Modifier.height(16.dp)) }
            item { BigChart() }
            item { Spacer(modifier = Modifier.height(32.dp)) }
            item { PositionsHeader() } // 9th indexed item!
            items(stocks) { model ->
                Stock(model)
            }
        }
    }
    val isSystemUiThresholdMet = (listState.firstVisibleItemIndex >= 9)
    val shouldShowDarkIcons = isSystemUiThresholdMet && isLight
    if (currentlyShowingDarkIcons != shouldShowDarkIcons) {
        ChangeSystemUi(darkIcons = shouldShowDarkIcons)
        setcurrentlyShowingDarkIcons(shouldShowDarkIcons)
    }
}

@Composable
fun ChangeSystemUi(darkIcons: Boolean) {
    val sysUiController = LocalSysUiController.current
    val colors = MaterialTheme.colors
    SideEffect {
        sysUiController.setSystemBarsColor(
            color = colors.surface.copy(alpha = 0.0f),
            darkIcons = darkIcons,
        )
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
                Column(modifier = Modifier.defaultMinSize(minWidth = 64.dp)) {
                    Text(
                        model.price,
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.paddingFromBaseline(top = 24.dp)
                    )
                    val changeColor = if (model.isChangePositive) green else red
                    Text(
                        model.change,
                        style = MaterialTheme.typography.body1.copy(color = changeColor),
                        modifier = Modifier.paddingFromBaseline(top = 16.dp, bottom = 16.dp)
                    )
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        model.symbol,
                        style = MaterialTheme.typography.h3,
                        modifier = Modifier.paddingFromBaseline(top = 24.dp)
                    )
                    Text(
                        model.name,
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.paddingFromBaseline(top = 16.dp, bottom = 16.dp)
                    )
                }
                Image(
                    painter = painterResource(model.res),
                    contentDescription = "Drawable Example",
                    modifier = Modifier
                        .height(56.dp)
                        .width(80.dp),
                    contentScale = ContentScale.Inside
                )
            }
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
        MyButtonText("Transact")
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
            .padding(horizontal = 16.dp),
        contentScale = ContentScale.FillWidth
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

// @Preview
@Composable
fun StockPreview() {
    MyTheme {
        Stock(stocks.first())
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
