package com.example.jetpackcomposetutorial

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposetutorial.ui.theme.Abeezee
import com.example.jetpackcomposetutorial.ui.theme.Aclonica
import com.example.jetpackcomposetutorial.ui.theme.AzulVooaz40
import com.example.jetpackcomposetutorial.ui.theme.BlackOcean
import com.example.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme
import com.example.jetpackcomposetutorial.ui.theme.Purple40

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTutorialTheme {
                Surface {
                   Conversation(SampleData.conversationSample)
                }
            }
        }
    }
}

// Armazenar dados de mensagem
data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {
    Row {
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "Menininha Luara",
            modifier = Modifier
                .size(40.dp)       // Tamanho da Imagem
                .padding(4.dp)     // Espaçamento
                .clip(CircleShape) // Formato da Imagem
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape) // Borda
        )

        Column {
            Text(
                text = msg.author,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = BlackOcean
            )
            Text(
                text = msg.body,
                fontSize = 12.sp,
                color = AzulVooaz40
            )
        }
    }
}

object SampleData {
    val conversationSample = listOf(
        Message("Onofre", "Hoje o dia vai ser incrível!"),
        Message("Bozanka", "Estou aprendendo muito neste universo. E essa mensagem é muito grande para caber em uma única linha."),
        Message("Licurgo", "Cuidado com o Leopardo."),
        Message("Ovalino", "Obrigado por acreditarem em mim."),
        Message("Cafiasparino", "Eu sou a flor silvestre que perfuma os campos! E essa mensagem é muito grande para caber em uma única linha.\"),"),
        Message("Ubelino", "Meu Amor... Aqui Está sua filha."),
        Message("Guilhermina", "Não contavam com a minha astúcia."),
        Message("Fedegunda", "Eu sou o mestre do universo!"),
        Message("Adamastor", "Chaves e Chapolin Colorado."),
        Message("Aretha", "Se você é jovem ainda, jovem ainda, jovem ainda. E essa mensagem é muito grande para caber em uma única linha.\"),"),
        Message("Abeba", "Amanhã é um novo dia."),
        Message("Epaminondas", "Ao infinito e além!"),
    )
}

@Composable
fun Conversation(messages: List<Message>) {

    Column {
        Text(
            text = "Lista de Mensagens",
            fontFamily = FontFamily.Cursive,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Purple40
        )
        LazyColumn {
            items(messages) { message ->
                MessageCard(message)
            }
        }

    }
}


@Preview(showBackground = true)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun Preview() {
    JetpackComposeTutorialTheme {
        Surface {
            Conversation(SampleData.conversationSample)
        }
    }
}