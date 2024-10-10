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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
            DadosTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Inicio(
                        name = "Android"
                    )
                }
            }
        }
    }
}

@Composable
fun Inicio(name: String, modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally, // Diferença entre Arrangement e Alignment: Arrangement é para o eixo principal, e Alignment é para o eixo secundário
        modifier = modifier
            .padding(top = 20.dp)
            .background(color = MaterialTheme.colorScheme.secondary)
    ) {

        // sp significa scale-independent pixels (pixels independentes de escala)
        Text(
            text = "Jogue os Dados",
            fontSize = 40.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontFamily = MaterialTheme.typography.titleLarge.fontFamily
        )

        Image(
            painter = painterResource(id = R.drawable.dados),
            contentDescription = "Dados",
            modifier = Modifier
                .width(200.dp)
                .padding(16.dp)
        )

        Button(
            onClick = { onClick() },
            colors = ButtonDefaults.buttonColors
                (containerColor =  MaterialTheme.colorScheme.tertiary,
                contentColor =  Color.White)
        ) {
            Text("Jogar")
        }

    }
}

fun onClick() {
    // TODO("Not yet implemented")
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