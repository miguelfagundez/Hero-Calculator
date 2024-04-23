package com.miguelfagundez.herocalculator.events

// Creating an internal class to handle all events used in Viewmodel
// Delete symbols, make calculations, etc
sealed class CalculatorEvents() {
    data class Number(val number: Int): CalculatorEvents()
    data class Operation(val operation: Operation?): CalculatorEvents()
    object Delete: CalculatorEvents()
    object Clear: CalculatorEvents()
    object Decimal: CalculatorEvents()
    object Porcentage: CalculatorEvents()
    object Result: CalculatorEvents()
}