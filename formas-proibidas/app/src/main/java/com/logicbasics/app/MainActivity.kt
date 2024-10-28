package com.logicbasics.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.logicbasics.app.ui.theme.FormasproibidasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FormasproibidasTheme {
                Inicio()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Inicio() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Portal das Formas")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        // Ação ainda não implementada
                    }) {
                        Icon(Icons.AutoMirrored.Filled.Send, contentDescription = "Voltar")
                    }
                }
            )
        },
        modifier = Modifier.fillMaxSize(),
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ConteudoLogin()
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* Ação do FAB */ }) {
                Icon(Icons.Default.Menu, contentDescription = "Adicionar")
                // Icone padrão do Material Design, mas pode ser substituído por qualquer coisa
                // Consultar mais ícones em https://material.io/resources/icons/
            }
        },
        bottomBar = {
            // Ação ainda não implementada
            BottomAppBar(
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            Icons.Filled.Check,
                            contentDescription = "Localized description")
                    }
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            Icons.Filled.Edit,
                            contentDescription = "Localized description",
                        )
                    }
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            Icons.Filled.Call,
                            contentDescription = "Ligar para o Estabelecimento",
                        )
                    }
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            Icons.Filled.LocationOn,
                            contentDescription = "Ver no Mapa",
                        )
                    }
                }
            )
        }
    )
}

@Composable
fun ConteudoLogin() {
    Text(
        text = "Bem-vindo ao Portal das Formas"
    )

    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.padding(16.dp)
    ) {
        Text("Login")
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    FormasproibidasTheme {
        Inicio()
    }
}