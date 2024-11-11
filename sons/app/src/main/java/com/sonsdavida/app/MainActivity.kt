package com.sonsdavida.app

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.platform.LocalContext
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
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Selecione um som para ajudar o bebê a dormir", fontSize = 20.sp, style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(16.dp))

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
    var isPlaying by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val mediaPlayer = remember { MediaPlayer.create(context, soundResId) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable {
                isPlaying = if (isPlaying) {
                    mediaPlayer.pause()
                    false
                } else {
                    mediaPlayer.start()
                    true
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
        Text(label, fontSize = 18.sp, style = MaterialTheme.typography.bodyLarge)
    }

    // DisposableEffect é um efeito que é executado quando o Composable é criado e é descartado quando o Composable é removido
    // Aqui estamos liberando o recurso de MediaPlayer quando o Composable é removido assim evitando memory leaks (despejo de memória) por não liberar recursos

    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer.release()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWhiteNoiseApp() {
    WhiteNoise()
}