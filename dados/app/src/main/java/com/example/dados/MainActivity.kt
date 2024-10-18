package com.example.dados

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dados.ui.theme.DadosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DadosTheme(dynamicColor = false) {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Inicio(name = "Android")
                }
            }
        }
    }
}

@Composable
fun Espacamento() {
    Spacer(modifier = Modifier.padding(16.dp))
}

@Composable
fun Inicio(name: String, modifier: Modifier = Modifier) {

    //var sorteio = 1
    var sorteio by remember {
        mutableStateOf(1)
    }

    val imagemEscolhida = when(sorteio) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    val listaNomes = when(sorteio){
        1 -> "Mulher-Gato"
        2 -> "Super-Boy"
        3 -> "Cebolácio Menezes Júnior da Silva"
        4 -> "Clarabela"
        5 -> "Enliqueta"
        else -> "Licurgo Ovalino Cafiaspirino Umbelino de Oliveira"
    }

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally, // Diferença entre Arrangement e Alignment: Arrangement é para o eixo principal, e Alignment é para o eixo secundário
        modifier = modifier
            .padding(top = 20.dp)
            .background(color = MaterialTheme.colorScheme.background)
    ) {

        // sp significa scale-independent pixels (pixels independentes de escala)
        Text(
            text = "Jogue os Dados",
            fontSize = 40.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(30.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.SansSerif
        )

        // dp significa density-independent pixels (pixels independentes de densidade)
        Image(
            painter = painterResource(id = imagemEscolhida),
            contentDescription = "Dados",
            modifier = Modifier
                .width(200.dp)
                .padding(bottom = 16.dp)
        )

        Espacamento()

        Button(
            onClick = {  sorteio = (1..6).random() },
            colors = ButtonDefaults.buttonColors
                (containerColor =  MaterialTheme.colorScheme.primary,
                contentColor =  Color.White)
        ) {
            Text("Sortear")
        }

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DadosTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Inicio(
                name = "Android"
            )
        }
    }
}