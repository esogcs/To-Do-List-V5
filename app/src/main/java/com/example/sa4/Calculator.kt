package com.example.sa4

class Calculator {
    fun calculate(firstNumber: Double, secondNumber: Double, operation: String): Double {
        return when (operation) {
            "+" -> firstNumber + secondNumber
            "-" -> firstNumber - secondNumber
            "×" -> firstNumber * secondNumber
            "÷" -> if (secondNumber != 0.0) firstNumber / secondNumber else Double.POSITIVE_INFINITY
            else -> secondNumber
        }
    }
} 