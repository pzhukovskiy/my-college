package com.example.project.utilities

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun calculateWidthForButton(textLength: Int): Dp {
    var len = 0.dp

    when(textLength) {
        1 -> len = 15.dp
        2 -> len = 30.dp
        3 -> len = 50.dp
        4 -> len = 70.dp
        5 -> len = 80.dp
        6 -> len = 90.dp
        7 -> len = 110.dp
        8 -> len = 130.dp
        9 -> len = 150.dp
        10 -> len = 120.dp
        11 -> len = 190.dp
        12 -> len = 200.dp
    }

    return  len
}