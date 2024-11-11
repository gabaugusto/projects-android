package com.logicbasics.app

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun Exemplo(navController: NavController, context: Context) {
    val mediaPlayer = MediaPlayer.create(context, R.raw.button)
    mediaPlayer.start()
    mediaPlayer.setOnCompletionListener {
        mediaPlayer.release()
    }

    Column {
        Button (
            onClick = {
                mediaPlayer.start()
            }
        ){
            Text("Play")
        }
    }
}