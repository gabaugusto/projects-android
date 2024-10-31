package com.example.portaldasformas

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.portaldasdformas.ui.theme.PortalDasDFormasTheme


//funcao consumir banco de dados mongodb
//funcao consumir banco de dados mongodb





@Composable
fun PaginaLogin() {
    Column {
        Text(text = "Bem-Vindo de Volta")
        Text(text = "Por favor, faça login para continuar")

        //Label e Caixa de Texto
        Text(text = "E-mail ou nome de usuário")
        OutlinedTextField(value = "", onValueChange = { /*TODO*/ }) //Campo de texto

        //Label e Caixa de Texto
        Text(text = "Senha")
        OutlinedTextField(value = "", onValueChange = { /*TODO*/ }) //Campo de texto

        Button(onClick = { /*TODO*/ }) {
            Text(text = "Login")
        }

        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "Esqueci a senha")
        }
    }
}


@Composable
fun PaginaCadastro() {
    Column {
        Text(text = "Crie uma conta")
        Text(text = "Por favor, preencha os campos abaixo para criar uma conta")

        //Label e Caixa de Texto
        Text(text = "Nome")
        OutlinedTextField(value = "", onValueChange = { /*TODO*/ }) //Campo de texto

        //Label e Caixa de Texto
        Text(text = "E-mail")
        OutlinedTextField(value = "", onValueChange = { /*TODO*/ }) //Campo de texto

        //Label e Caixa de Texto
        Text(text = "Senha")
        OutlinedTextField(value = "", onValueChange = { /*TODO*/ }) //Campo de texto

        Button(onClick = { /*TODO*/ }) {
            Text(text = "Cadastrar")
        }
    }
}

@Composable
fun PaginaEsqueciaSenha() {
    Column {
        Text(text = "Esqueci a senha")
        Text(text = "Por favor, informe o e-mail cadastrado para recuperar a senha")

        //Label e Caixa de Texto
        Text(text = "E-mail")
        OutlinedTextField(value = "", onValueChange = { /*TODO*/ })

        Button(onClick = { /*TODO*/ }) {
            Text(text = "Recuperar senha")
        }
    }
}

@Composable
fun PaginaSucessoCadastro() {
    Column() {
        Text(text = "Cadastro realizado com sucesso")
        Text(text = "Seja bem-vindo ao $appName")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Continuar")
        }
    }
}