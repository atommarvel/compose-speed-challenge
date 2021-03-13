package com.example.androiddevchallenge.ui.theme

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.baselineHeight(topPadding: Dp = 0.dp, bottomPadding: Dp = 0.dp): Modifier =
    layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)
        val top = topPadding.roundToPx() - placeable[FirstBaseline]
        val height = top + placeable[LastBaseline] + bottomPadding.roundToPx()
        layout(placeable.width, height) {
            placeable.place(0, top)
        }
    }