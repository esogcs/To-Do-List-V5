package com.example.sa4

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CalculatorScreen() {
    val viewModel: CalculatorViewModel = viewModel()
    val display by viewModel.display.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display
        Text(
            text = display,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp),
            textAlign = TextAlign.End,
            fontSize = 48.sp
        )

        // Calculator buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CalculatorButton("7") { viewModel.onNumberClick("7") }
            CalculatorButton("8") { viewModel.onNumberClick("8") }
            CalculatorButton("9") { viewModel.onNumberClick("9") }
            CalculatorButton("÷") { viewModel.onOperationClick("÷") }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CalculatorButton("4") { viewModel.onNumberClick("4") }
            CalculatorButton("5") { viewModel.onNumberClick("5") }
            CalculatorButton("6") { viewModel.onNumberClick("6") }
            CalculatorButton("×") { viewModel.onOperationClick("×") }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CalculatorButton("1") { viewModel.onNumberClick("1") }
            CalculatorButton("2") { viewModel.onNumberClick("2") }
            CalculatorButton("3") { viewModel.onNumberClick("3") }
            CalculatorButton("-") { viewModel.onOperationClick("-") }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CalculatorButton("0") { viewModel.onNumberClick("0") }
            CalculatorButton(".") { viewModel.onDecimalClick() }
            CalculatorButton("=") { viewModel.onEqualsClick() }
            CalculatorButton("+") { viewModel.onOperationClick("+") }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CalculatorButton("C") { viewModel.onClearClick() }
        }
    }
}

@Composable
fun CalculatorButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .size(72.dp)
            .padding(4.dp)
    ) {
        Text(text = text, fontSize = 24.sp)
    }
} 