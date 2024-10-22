package com.example.portaldasformas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.portaldasdformas.ui.theme.PortalDasDFormasTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.portaldasdformas.ui.theme.PortalDasDFormasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PortalDasDFormasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PaginaInicial()
                }
            }
        }
    }
}

const val appName = "Portal das Formas"


@Composable
fun PaginaInicial() {
    Column {
        Text(text = "Portal das Formas")
        Text(text = "Bem-vindo ao $appName")
        Text(text = "Informe seus dados para continuar")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Login")
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Cadastrar")
        }
    }
}

@Composable
fun MenuPrincipal(
    onNavigateToHome: () -> Unit,
    onNavigateToTermos: () -> Unit,
    onNavigateToPaginaInicial: () -> Unit
) {
    Column {
        Button(onClick = onNavigateToHome) {
            Text(text = "Home")
        }
        Button(onClick = onNavigateToTermos) {
            Text(text = "Termos de Uso")
        }
        Button(onClick = onNavigateToPaginaInicial) {
            Text(text = "Página Inicial")
        }
    }
}

@Composable
fun Navegacao() {
    Row {
        MenuPrincipal(
            onNavigateToHome = { /* Navegar para Home */ },
            onNavigateToTermos = { /* Navegar para Termos */ },
            onNavigateToPaginaInicial = { /* Navegar para PaginaInicial */ }
        )
        // Conteúdo adicional da Composable
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "pagina_inicial") {
        composable("pagina_inicial") { PaginaInicial(navController) }
        composable("home") { Home() }
        composable("termos") { Termos() }
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    PortalDasDFormasTheme {
        Circulo()
    }
}