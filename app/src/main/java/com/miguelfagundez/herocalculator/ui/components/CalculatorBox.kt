package com.miguelfagundez.herocalculator.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miguelfagundez.herocalculator.events.CalculatorEvents
import com.miguelfagundez.herocalculator.events.CalculatorOperation
import com.miguelfagundez.herocalculator.state.CalculatorState
import com.miguelfagundez.herocalculator.ui.theme.LightGray
import com.miguelfagundez.herocalculator.ui.theme.Orange

@Composable
fun CalculatorBox(
    // Box info such as background color, shape, spacing, etc
    info: Modifier,
    btnSpacing: Dp = 8.dp,
    // Current App state (rotation, update, delete, etc)
    state: CalculatorState,
    action: (CalculatorEvents) -> Unit
){
    // Calculator Upper View
    Box(modifier = info){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(btnSpacing)
        ) {
            AutoResizedText(
                text = state.numberOne + (state.operator?.symbol ?: "") + state.numberTwo,
                style = MaterialTheme.typography.displayLarge.copy(
                    fontSize = 80.sp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
            )
            // Calculator Buttons in 5 rows
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(btnSpacing)
            ){
                CalculatorButton(
                    symbol = "AC",
                    info = Modifier
                        .background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {action(CalculatorEvents.Clear)}
                )
                CalculatorButton(
                    symbol = "<-",
                    info = Modifier
                        .background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {action(CalculatorEvents.Delete)}
                )
                CalculatorButton(
                    symbol = "%",
                    info = Modifier
                        .background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {action(CalculatorEvents.Operation(CalculatorOperation.Percentage))}
                )
                CalculatorButton(
                    symbol = "/",
                    info = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {action(CalculatorEvents.Operation(CalculatorOperation.Divide))}
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(btnSpacing)
            ){
                CalculatorButton(
                    symbol = "7",
                    info = Modifier
                        .background(DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {action(CalculatorEvents.Number(7))}
                )
                CalculatorButton(
                    symbol = "8",
                    info = Modifier
                        .background(DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {action(CalculatorEvents.Number(8))}
                )
                CalculatorButton(
                    symbol = "9",
                    info = Modifier
                        .background(DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {action(CalculatorEvents.Number(9))}
                )
                CalculatorButton(
                    symbol = "x",
                    info = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {action(CalculatorEvents.Operation(CalculatorOperation.Multiply))}
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(btnSpacing)
            ){
                CalculatorButton(
                    symbol = "4",
                    info = Modifier
                        .background(DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {action(CalculatorEvents.Number(4))}
                )
                CalculatorButton(
                    symbol = "5",
                    info = Modifier
                        .background(DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {action(CalculatorEvents.Number(5))}
                )
                CalculatorButton(
                    symbol = "6",
                    info = Modifier
                        .background(DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {action(CalculatorEvents.Number(6))}
                )
                CalculatorButton(
                    symbol = "-",
                    info = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {action(CalculatorEvents.Operation(CalculatorOperation.Subtract))}
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(btnSpacing)
            ){
                CalculatorButton(
                    symbol = "1",
                    info = Modifier
                        .background(DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {action(CalculatorEvents.Number(1))}
                )
                CalculatorButton(
                    symbol = "2",
                    info = Modifier
                        .background(DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {action(CalculatorEvents.Number(2))}
                )
                CalculatorButton(
                    symbol = "3",
                    info = Modifier
                        .background(DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {action(CalculatorEvents.Number(3))}
                )
                CalculatorButton(
                    symbol = "+",
                    info = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {action(CalculatorEvents.Operation(CalculatorOperation.Add))}
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(btnSpacing)
            ){
                CalculatorButton(
                    symbol = "0",
                    info = Modifier
                        .background(DarkGray)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {action(CalculatorEvents.Number(0))}
                )
                CalculatorButton(
                    symbol = ".",
                    info = Modifier
                        .background(DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {action(CalculatorEvents.Decimal)}
                )
                CalculatorButton(
                    symbol = "=",
                    info = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {action(CalculatorEvents.Result)}
                )
            }
        }
    }

}