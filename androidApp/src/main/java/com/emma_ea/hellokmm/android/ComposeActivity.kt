package com.emma_ea.hellokmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable


class ComposeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HelloKMMTheme {
               Greetings()
            }
        }
    }

    @Composable
    fun Greetings() {
        Text(text = "Hello, KMM")
    }

}
