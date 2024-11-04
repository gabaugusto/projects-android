package com.logicbasics.app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun ConteudoCirculo(navController: NavController) {
    val navController = rememberNavController() // Cria uma instância do NavController

    // Regras de negócio = Backend
    // raio é uma variável que armazena o valor do campo de texto

    var raio by remember { mutableStateOf("") }
    var area by remember { mutableStateOf<Double?>(null) }

    Column {

        Spacer(modifier = Modifier.padding(top = 32.dp))

        Text("Circulo")
        Text(
            "A geometria serve como a linguagem fundamental do mundo físico, uma lente matemática profunda através da qual compreendemos formas, estruturas e relações espaciais. Da elegância dos padrões simétricos à complexidade das formas geométricas, a geometria permanece como uma ferramenta indispensável, moldando tanto o nosso intelecto como o mundo tangível que habitamos.\n" +
                    "\n"
        )

        Column (
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            OutlinedTextField(
                value = raio,
                onValueChange = {
                    // OnValueChange é chamado toda vez que o valor do campo de texto é alterado
                    // it é o valor do campo de texto (raio)
                    raio = it
                    area = if (raio.isNotEmpty()) Math.PI * raio.toDouble() * raio.toDouble() else 0.0
                    area = if (raio.isNotEmpty()) {
                        // Math.PI é uma constante que representa o valor de PI
                        // PI vale aproximadamente 3.141592653589793
                        Math.PI * raio.toDouble() * raio.toDouble()
                    } else {
                        0.0
                    }
                },

                // KeyBoard = Teclado. KeyboardOptions é uma classe que permite configurar o teclado
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                ),

                label = { Text("Digite o raio") },
                modifier = Modifier.padding(16.dp)
                    .fillMaxWidth()
            )

            Button(
                onClick = {
                    area = if (raio.isNotEmpty()) Math.PI * raio.toDouble() * raio.toDouble() else 0.0
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Calcular Área")
            }

            Spacer(modifier = Modifier.padding(top = 16.dp))

            Text("Área: $area")


        }

    }
}