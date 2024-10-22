package com.example.portaldasformas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun Home() {
    Column() {

        Text(text = "Bem-vindo ao Portal das Formas")
        Text("Escolha uma forma geométrica:")

        // Adiciona um botão para cada forma geométrica
        Row{
            Image(
                painter = painterResource(id = R.drawable.circulo),
                contentDescription = "Círculo",
                modifier = Modifier.size(20.dp)
            )
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Círculo")
            }
        }

        Row{
            Image(
                painter = painterResource(id = R.drawable.retangulo),
                contentDescription = "Retangulo",
                modifier = Modifier.size(20.dp)
            )
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Retângulo")
            }
        }

        Row{
            Image(
                painter = painterResource(id = R.drawable.hexagono),
                contentDescription = "Retangulo",
                modifier = Modifier.size(20.dp)
            )
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Hexágono")
            }
        }
    }
}

@Composable
fun Circulo() {
    Column {

        var raio = 0.0
        var area = 0.0

        Text(text = "Círculo")
        Image(
            painter = painterResource(id = R.drawable.circulo),
            contentDescription = "Círculo"
        )

        Text(text = "Raio")
        OutlinedTextField(value = "", onValueChange = {
            raio = it.toDouble()
        })

        Button(onClick = {
            area = 3.14 * raio * raio        }) {
            Text(text = "Calcular área")
        }

        Text(text = "Área: $area")
    }

}

@Composable
fun Retangulo() {
    Column {

        var altura = 0.0
        var base = 0.0
        var area = 0.0

        Text(text = "Retangulo")
        Image(
            painter = painterResource(id = R.drawable.retangulo),
            contentDescription = "Retangulo"
        )

        Text(text = "Altura")
        OutlinedTextField(value = "", onValueChange = {
            altura = it.toDouble()
        })

        Text(text = "Base")
        OutlinedTextField(value = "", onValueChange = {
            base = it.toDouble()
        })


        Button(onClick = {
            area = base * altura
        }) {
            Text(text = "Calcular área")
        }

        Text(text = "Área: $area")
    }

}

@Composable
fun Hexagono() {
    Column {

        var lado = 0.0
        var area = 0.0

        Text(text = "Hexágono")
        Image(
            painter = painterResource(id = R.drawable.hexagono),
            contentDescription = "Hexágono"
        )

        Text(text = "Lado")
        OutlinedTextField(value = "", onValueChange = {
            lado = it.toDouble()
        })

        Button(onClick = {
            area = 3 * lado * lado * 1.732 / 2
        }) {
            Text(text = "Calcular área")
        }

        Text(text = "Área: $area")
    }

}