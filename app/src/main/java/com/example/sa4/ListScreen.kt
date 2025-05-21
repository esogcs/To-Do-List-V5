package com.example.sa4

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun ListScreen(
    viewModel: EventViewModel,
    onDoubleTap: () -> Unit
) {
    val events by viewModel.allEvents.collectAsState()
    val context = LocalContext.current

    Column(
        Modifier
            .padding(16.dp)
            .clickable { onDoubleTap() }
    ) {
        Text("Event List")
        events.forEach { event ->
            var isChecked by remember { mutableStateOf(false) }
            var isEditing by remember { mutableStateOf(false) }

            var newName by remember { mutableStateOf(event.name) }
            var newDetails by remember { mutableStateOf(event.details) }
            var newDate by remember { mutableStateOf(event.date) }
            var newTime by remember { mutableStateOf(event.time) }
            var newAddress by remember { mutableStateOf(event.address) }
            var newLatitude by remember { mutableStateOf(event.latitude.toString()) }
            var newLongitude by remember { mutableStateOf(event.longitude.toString()) }

            Card(Modifier.padding(8.dp)) {
                Column(Modifier.padding(16.dp)) {
                    if (isEditing) {
                        OutlinedTextField(
                            value = newName,
                            onValueChange = { newName = it },
                            label = { Text("Name") })
                        OutlinedTextField(
                            value = newDetails,
                            onValueChange = { newDetails = it },
                            label = { Text("Details") })
                        OutlinedTextField(
                            value = newDate,
                            onValueChange = { newDate = it },
                            label = { Text("Date") })
                        OutlinedTextField(
                            value = newTime,
                            onValueChange = { newTime = it },
                            label = { Text("Time") })
                        OutlinedTextField(
                            value = newAddress,
                            onValueChange = { newAddress = it },
                            label = { Text("Address") })
                        OutlinedTextField(
                            value = newLatitude,
                            onValueChange = { newLatitude = it },
                            label = { Text("Latitude") })
                        OutlinedTextField(
                            value = newLongitude,
                            onValueChange = { newLongitude = it },
                            label = { Text("Longitude") })

                        Button(onClick = {
                            viewModel.edit(
                                original = event,
                                newName = newName,
                                newDetails = newDetails,
                                newDate = newDate,
                                newTime = newTime,
                                newAddress = newAddress,
                                newLatitude = newLatitude.toDoubleOrNull() ?: 0.0,
                                newLongitude = newLongitude.toDoubleOrNull() ?: 0.0
                            )
                            isEditing = false
                        }) {
                            Text("Save")
                        }
                    } else {
                        Text("${event.name}\n${event.date} at ${event.time}\n${event.address}\n(${event.latitude}, ${event.longitude})")
                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Checkbox(
                                checked = isChecked,
                                onCheckedChange = {
                                    isChecked = it
                                    if (it) {
                                        viewModel.remove(event)
                                    }
                                }
                            )
                            IconButton(onClick = {
                                isEditing = true
                            }) {
                                Icon(Icons.Default.Edit, contentDescription = "Edit")
                            }
                        }
                    }
                }
            }
        }

        Button(onClick = {
            NotificationHelper.notify(
                context = context,
                id = 999,
                title = "Test Notification",
                message = "This is a test notification!"
            )
        }) {
            Text("Send Test Notification")
        }
    }
}
