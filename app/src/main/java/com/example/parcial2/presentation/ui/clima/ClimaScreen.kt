package com.example.parcial2.presentation.ui.clima

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ClimaScreen(
    viewModel: ClimaViewModel = viewModel(),
    ciudad: String,
    apiKey: String
) {

    LaunchedEffect(Unit) {
        viewModel.obtenerClima(ciudad, apiKey)
    }


    val clima by viewModel.clima.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        clima?.let {

            Text(
                text = "El Clima de ${it.cityName}",
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "La temperatura actual es ${it.temperature}°C",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "La temperatura mínima es : ${it.minTemp}°C, y la máxima es ${it.maxTemp}°C",
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = "Descripción: ${it.description}",
                style = MaterialTheme.typography.bodySmall
            )
        } ?: Text(
            text = "Cargando, aguarde por favor...",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
