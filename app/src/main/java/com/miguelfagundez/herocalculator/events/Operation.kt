package com.miguelfagundez.herocalculator.events

sealed class Operation(val symbol: String) {
    object Add: Operation("+")
    object Subtract: Operation("-")
    object Multiply: Operation("*")
    object Porcentage: Operation("%")
    object Divide: Operation("/")

}