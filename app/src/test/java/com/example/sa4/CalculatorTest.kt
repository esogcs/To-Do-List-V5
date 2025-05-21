package com.example.sa4

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CalculatorTest {
    private lateinit var calculator: Calculator

    @Before
    fun setup() {
        calculator = Calculator()
    }

    @Test
    fun testAddition() {
        val result = calculator.calculate(5.0, 3.0, "+")
        assertEquals(8.0, result, 0.001)
    }

    @Test
    fun testSubtraction() {
        val result = calculator.calculate(10.0, 4.0, "-")
        assertEquals(6.0, result, 0.001)
    }

    @Test
    fun testMultiplication() {
        val result = calculator.calculate(6.0, 7.0, "×")
        assertEquals(42.0, result, 0.001)
    }

    @Test
    fun testDivision() {
        val result = calculator.calculate(15.0, 3.0, "÷")
        assertEquals(5.0, result, 0.001)
    }

    @Test
    fun testDivisionByZero() {
        val result = calculator.calculate(5.0, 0.0, "÷")
        assertEquals(Double.POSITIVE_INFINITY, result, 0.001)
    }

    @Test
    fun testInvalidOperation() {
        val result = calculator.calculate(5.0, 3.0, "invalid")
        assertEquals(3.0, result, 0.001)
    }
}

class Calculator {
    fun calculate(firstNumber: Double, secondNumber: Double, operation: String): Double {
        return when (operation) {
            "+" -> firstNumber + secondNumber
            "-" -> firstNumber - secondNumber
            "×" -> firstNumber * secondNumber
            "÷" -> firstNumber / secondNumber
            else -> secondNumber
        }
    }
} 