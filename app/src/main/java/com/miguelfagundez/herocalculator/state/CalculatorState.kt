package com.miguelfagundez.herocalculator.state

import com.miguelfagundez.herocalculator.events.CalculatorOperation

data class CalculatorState(
    // We can change later for a list of numbers/operations
    val numberOne: String = "",
    val operator: CalculatorOperation? = null,
    val numberTwo: String = ""
) {
}