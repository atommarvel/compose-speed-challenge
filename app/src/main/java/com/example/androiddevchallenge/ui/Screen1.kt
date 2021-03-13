package com.example.androiddevchallenge.screen1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.LocalNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.Screen2Route
import com.example.androiddevchallenge.ui.MyButton
import com.example.androiddevchallenge.ui.MyTheme

@Composable
fun Screen1Root() {
    Screen1()
}

@Composable
fun Screen1() {
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
            NavigationExample()
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
        textAlign = TextAlign.Center
    )
}

@Composable
fun DrawableExample() {
    val res = if (MaterialTheme.colors.isLight) R.drawable.ic_light_logo else R.drawable.ic_dark_logo
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
fun NavigationExample() {
    val navController = LocalNavController.current
    MyButton(
        onClick = { navController.navigate(Screen2Route) }
    ) {
        Text(text = "Navigate to Screen 2")
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        Screen1Root()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        Screen1Root()
    }
}