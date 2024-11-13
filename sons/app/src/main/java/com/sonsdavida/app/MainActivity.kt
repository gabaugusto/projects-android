package com.sonsdavida.app

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sonsdavida.app.ui.theme.SonsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SonsTheme {
                WhiteNoise()
            }
        }
    }
}

@Composable
fun WhiteNoise() {
    Row (
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {}

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Selecione um som para ajudar o bebê a dormir", fontSize = 20.sp, style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier
            .height(16.dp)
            .border(width = 1.dp, color = MaterialTheme.colorScheme.onSurface)
        )

        SoundButton("Som de Ventilador", R.drawable.icon_fan, R.raw.fan)
        Spacer(modifier = Modifier.height(8.dp))
        SoundButton("Som de Oceano", R.drawable.icon_ocean, R.raw.ocean)
        Spacer(modifier = Modifier.height(8.dp))
        SoundButton("Som de Chuva", R.drawable.icon_rain, R.raw.rain)
    }
}


// SoundButton é um Composable que exibe um botão com um ícone e um rótulo
// Quando o botão é clicado, ele reproduz um som
// Essa função é reutilizável e pode ser usada para exibir vários botões de som

@Composable
fun SoundButton(label: String, iconResId: Int, soundResId: Int) {
    // remember é uma função que armazena um valor e o mantém entre recomposições
    // estaTocando é um valor booleano que indica se o som está sendo reproduzido.
    var estaTocando by remember { mutableStateOf(false) }

    // context é uma variável que armazena o contexto atual ou seja a Activity atual
    val context = LocalContext.current

    // ruido branco é um recurso de MediaPlayer que reproduz o som
    val ruidoBranco = remember { MediaPlayer.create(context, soundResId) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable { // clickable é um modificador que torna o Composable clicável
                estaTocando = if (estaTocando) {
                    // pause é uma função que pausa a reprodução do som
                    // pause é diferente de stop porque mantém o recurso de MediaPlayer ativo
                    // Isso significa que o som pode ser retomado de onde parou, mas também que continua ocupando memória
                    // Já com o stop o recurso de MediaPlayer é liberado e o som não pode ser retomado
                    ruidoBranco.pause()
                    false // o valor de estaTocando é alterado para false
                } else {
                    // Start é uma função que inicia a reprodução do som OU reinicia caso o som esteja parado.
                    ruidoBranco.start()
                    true // o valor de estaTocando é alterado para true
                }
            }
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(iconResId),
            contentDescription = label,
            modifier = Modifier.size(48.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(label, fontSize = 18.sp,
            style = MaterialTheme.typography.bodyLarge)
    }

    // DisposableEffect é um efeito que é executado quando o Composable é criado e é descartado quando o Composable é removido
    // Aqui estamos liberando o recurso de MediaPlayer quando o Composable é removido assim evitando memory leaks (despejo de memória) por não liberar recursos
    DisposableEffect(Unit) {
        onDispose {
            ruidoBranco.release()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWhiteNoiseApp() {
    WhiteNoise()
}