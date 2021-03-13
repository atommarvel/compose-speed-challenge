package com.example.androiddevchallenge.ui

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyShapes

/**
 * Example.
 * Do this if the design spec has custom shape-to-component mappings that ARE actually found in the screens.
 */
@Composable
fun MyButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    height: Dp = 48.dp,
    content: @Composable RowScope.() -> Unit
) {

    Button(
        shape = MyShapes.medium,
        onClick = onClick,
        modifier = modifier
            .height(height)
            .fillMaxWidth(),
        content = content,
        elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
    )
}

@Composable
fun MyCard(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Card(
        modifier = modifier,
        shape = MyShapes.small,
        content = content
    )
}