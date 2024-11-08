package com.logicbasics.app

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.logicbasics.app.ui.theme.FormasproibidasTheme
import android.media.MediaPlayer
import androidx.compose.ui.platform.LocalContext

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

    val navController = rememberNavController() // Cria uma instância do NavController

    val currentDestination = navController.currentBackStackEntryAsState().value?.destination?.route

    var paginas_com_barra_superior = listOf("circulo", "home")

    Scaffold(
        topBar = {

            TopAppBar(
                title = {
                    if (currentDestination == "circulo") {
                        Text("Círculo")
                    } else if (currentDestination == "home") {
                        Text("Bem-vindo ao Portal das Formas")
                    } else {
                        Text("Portal das Formas")
                    }

                },
                navigationIcon = {
                    if (currentDestination == "circulo") {

                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(
                                Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Voltar"
                            )
                        }

                    } else if (currentDestination == "home") {
                        IconButton(onClick = { navController.navigate("login") }) {
                            Icon(Icons.AutoMirrored.Filled.List, contentDescription = "Lista")
                        }

                    } else null
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
                // MavHost é o componente que gerencia a navegação entre as telas
                NavHost(navController = navController, startDestination = "login") {

                    // Definindo nossas rotas de navegação
                    composable("login") {
                        val context = LocalContext.current
                        ConteudoLogin(navController, innerPadding, context)
                    }
                    composable("home") { Home(navController) }
                    composable("circulo") { ConteudoCirculo(navController) }

                }
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
                            contentDescription = "Localized description"
                        )
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
fun ConteudoLogin(navController: NavController, innerPadding: PaddingValues, context: Context) {
    val mediaPlayer = MediaPlayer.create(context, R.raw.button)

    Column {
        Text(
            text = "Bem-vindo ao Portal das Formas"
        )

        Button(
            onClick = {
                navController.navigate("home")
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Home")
        }

        Button(
            onClick = {
                navController.navigate("circulo")
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Circulo")
        }

        Button (
            onClick = {
                mediaPlayer.start()
            },
            modifier = Modifier.padding(16.dp)
        ){
            Text("Play")
        }
    }
}

@Composable
fun Home(navController: NavController) {

    Row {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .background(color = Color.Yellow)
        ) {
            Button(
                onClick = {
                    navController.navigate("circulo")
                }
            ) {
                Text("Círculo")
            }
        }
        Box(
            modifier = Modifier
                .padding(16.dp)
                .background(color = Color.Red)
        ) {
            Button(
                onClick = {
                    navController.navigate("circulo")
                }
            ) {
                Text("Círculo")
            }
        }
        Box(
            modifier = Modifier
                .padding(24.dp)
                .background(color = Color.Blue)
        ) {
            Button(
                onClick = {
                    navController.navigate("circulo")
                }
            ) {
                Text("Círculo")
            }
        }
        Box(
            modifier = Modifier
                .padding(32.dp)
                .background(color = Color.Green)
        ) {
            Button(
                onClick = {
                    navController.navigate("circulo")
                }
            ) {
                Text("Círculo")
            }
        }
        Box(
            modifier = Modifier
                .padding(36.dp)
                .background(color = Color.Cyan)
        ) {
            Button(
                onClick = {
                    navController.navigate("circulo")
                }
            ) {
                Text("Círculo")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    FormasproibidasTheme {
        Inicio()
    }
}