package com.miguelfagundez.herocalculator.events

sealed class CalculatorOperation(val symbol: String) {
    object Add: CalculatorOperation("+")
    object Subtract: CalculatorOperation("-")
    object Multiply: CalculatorOperation("*")
    object Percentage: CalculatorOperation("%")
    object Divide: CalculatorOperation("/")

}