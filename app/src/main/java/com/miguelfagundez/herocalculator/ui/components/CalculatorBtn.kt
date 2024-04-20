package com.miguelfagundez.herocalculator.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorButton(
    // Calculator symbol suc as number, text, etc
    symbol: String,
    // Button info such as background color, shape, spacing, etc
    info: Modifier,
    // Text Size by default 36 units
    textSize: TextUnit = 36.sp,
    // Text symbol color by default is white
    textColor: Color = Color.White,
    // Button action/event
    onClick: () -> Unit
){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(CircleShape)
            .clickable { onClick }
            // Apply our modifier at the end of component properties.
            // First circle shape and onclick event is applied
            .then(info)
    ){
        Text(
            text = symbol,
            fontSize = textSize,
            color = textColor
        )
    }
}