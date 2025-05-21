package com.example.sa4

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CalculatorViewModelTest {
    private lateinit var viewModel: CalculatorViewModel

    @Before
    fun setup() {
        viewModel = CalculatorViewModel()
    }

    @Test
    fun testInitialDisplay() = runBlocking {
        assertEquals("0", viewModel.display.first())
    }

    @Test
    fun testNumberInput() = runBlocking {
        viewModel.onNumberClick("5")
        assertEquals("5", viewModel.display.first())
    }

    @Test
    fun testMultipleNumberInput() = runBlocking {
        viewModel.onNumberClick("1")
        viewModel.onNumberClick("2")
        viewModel.onNumberClick("3")
        assertEquals("123", viewModel.display.first())
    }

    @Test
    fun testAddition() = runBlocking {
        viewModel.onNumberClick("5")
        viewModel.onOperationClick("+")
        viewModel.onNumberClick("3")
        viewModel.onEqualsClick()
        assertEquals("8", viewModel.display.first())
    }

    @Test
    fun testSubtraction() = runBlocking {
        viewModel.onNumberClick("10")
        viewModel.onOperationClick("-")
        viewModel.onNumberClick("4")
        viewModel.onEqualsClick()
        assertEquals("6", viewModel.display.first())
    }

    @Test
    fun testMultiplication() = runBlocking {
        viewModel.onNumberClick("6")
        viewModel.onOperationClick("×")
        viewModel.onNumberClick("7")
        viewModel.onEqualsClick()
        assertEquals("42", viewModel.display.first())
    }

    @Test
    fun testDivision() = runBlocking {
        viewModel.onNumberClick("15")
        viewModel.onOperationClick("÷")
        viewModel.onNumberClick("3")
        viewModel.onEqualsClick()
        assertEquals("5", viewModel.display.first())
    }

    @Test
    fun testDecimalInput() = runBlocking {
        viewModel.onNumberClick("1")
        viewModel.onDecimalClick()
        viewModel.onNumberClick("5")
        assertEquals("1.5", viewModel.display.first())
    }

    @Test
    fun testClear() = runBlocking {
        viewModel.onNumberClick("1")
        viewModel.onNumberClick("2")
        viewModel.onNumberClick("3")
        viewModel.onClearClick()
        assertEquals("0", viewModel.display.first())
    }
} 