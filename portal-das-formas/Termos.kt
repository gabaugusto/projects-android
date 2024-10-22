package com.example.portaldasformas

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun Termos() {
    Column {
        Text(text = "Termos de Uso")
        Text(text = "Ao acessar o Portal das Formas, você concorda com os termos de uso.")
        Text(text = "1. Você pode usar o Portal das Formas para aprender sobre formas geométricas.")
        Text(text = "2. Você não pode copiar ou distribuir o conteúdo do Portal das Formas.")
        Text(text = "3. Você não pode usar o Portal das Formas para fins comerciais.")
    }
}