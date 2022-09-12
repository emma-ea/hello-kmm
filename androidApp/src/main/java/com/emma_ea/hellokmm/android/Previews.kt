package com.emma_ea.hellokmm.android

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview("greetings")
@Composable
fun Previews() {
    Greetings()
}

@Composable
fun Greetings() {
    Text(text = "Hello, Migrating to Compose")
}