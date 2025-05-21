package com.example.sa4

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CalculatorViewModel : ViewModel() {
    private val _display = MutableStateFlow("0")
    val display: StateFlow<String> = _display.asStateFlow()

    private val calculator = Calculator()
    private var firstNumber: Double? = null
    private var operation: String? = null
    private var newNumber = true

    fun onNumberClick(number: String) {
        if (newNumber) {
            _display.value = number
            newNumber = false
        } else {
            _display.value += number
        }
    }

    fun onOperationClick(op: String) {
        firstNumber = _display.value.toDoubleOrNull()
        operation = op
        newNumber = true
    }

    fun onEqualsClick() {
        val secondNumber = _display.value.toDoubleOrNull() ?: return
        val first = firstNumber ?: return
        val op = operation ?: return

        val result = calculator.calculate(first, secondNumber, op)
        _display.value = if (result == result.toInt().toDouble()) {
            result.toInt().toString()
        } else {
            result.toString()
        }
        newNumber = true
    }

    fun onClearClick() {
        _display.value = "0"
        firstNumber = null
        operation = null
        newNumber = true
    }

    fun onDecimalClick() {
        if (!_display.value.contains(".")) {
            _display.value += "."
        }
    }
} 