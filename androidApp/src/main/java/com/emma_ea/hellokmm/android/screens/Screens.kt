package com.emma_ea.hellokmm.android.screens

sealed class Screens(val route: String) {
    object Home : Screens("home-screen")
}
