package com.miguelfagundez.herocalculator.state

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf

import androidx.lifecycle.ViewModel
import com.miguelfagundez.herocalculator.events.CalculatorEvents
import com.miguelfagundez.herocalculator.events.CalculatorOperation

class CalculatorViewModel: ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set

    companion object {
        private const val MAX_NUM = 8
    }
    fun action(action: CalculatorEvents){
        Log.d("MainActivity", "${action.toString()}")
        when(action){
            is CalculatorEvents.Number -> enterNumber(action.number)
            is CalculatorEvents.Decimal -> enterDecimal()
            is CalculatorEvents.Clear -> clearState()
            is CalculatorEvents.Operation -> enterOperation(action.operation)
            is CalculatorEvents.Result -> calculateResult()
            is CalculatorEvents.Delete -> performDelete()
        }
    }

    private fun enterDecimal() {
        if(state.operator == null && !state.numberOne.contains(".") && state.numberOne.isNotBlank()){
            state = state.copy(
                numberOne = state.numberOne + "."
            )
            return
        }
        if(!state.numberTwo.contains(".") && state.numberTwo.isNotBlank()){
            state = state.copy(
                numberTwo = state.numberTwo + "."
            )
            return
        }

    }

    private fun enterNumber(number: Int) {
        Log.d("MainActivity", "$number")
        if(state.operator == null){
            if(state.numberOne.length > MAX_NUM){
                return
            }
            state = state.copy(
                numberOne = state.numberOne + number
            )
            return
        }
        if(state.numberTwo.length > MAX_NUM){
            return
        }
        state = state.copy(
            numberTwo = state.numberTwo + number
        )
    }

    private fun clearState() {
        state = state.copy(
            numberOne = "",
            numberTwo = "",
            operator = null
        )
    }

    private fun enterOperation(operator: CalculatorOperation?) {
        if (state.numberOne.isNotBlank()){
            state = state.copy(operator = operator)
        }

    }

    private fun calculateResult() {
        val numberOne = state.numberOne.toDoubleOrNull()
        val numberTwo = state.numberTwo.toDoubleOrNull()

        if(numberOne != null && numberTwo != null){
            val result = when(state.operator){
                is CalculatorOperation.Add -> numberOne + numberTwo
                is CalculatorOperation.Subtract -> numberOne - numberTwo
                is CalculatorOperation.Multiply -> numberOne * numberTwo
                is CalculatorOperation.Divide -> numberOne / numberTwo
                is CalculatorOperation.Percentage -> (numberOne/100)*numberTwo
                null -> return
            }
            state = state.copy(
                numberOne = result.toString().take(11),
                numberTwo = "",
                operator = null
            )
        }
    }

    private fun performDelete() {
        when{
            state.numberTwo.isNotBlank() -> state = state.copy(numberTwo = state.numberTwo.dropLast(1))
            state.operator != null -> state = state.copy(operator = null)
            state.numberOne.isNotBlank() -> state = state.copy(numberOne = state.numberOne.dropLast(1))
        }
    }
}