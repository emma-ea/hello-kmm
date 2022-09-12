package com.emma_ea.hellokmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.emma_ea.hellokmm.android.screens.Home
import com.emma_ea.hellokmm.android.screens.Screens
import com.emma_ea.hellokmm.android.viewmodel.HomeViewModel


class ComposeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HelloKMMTheme {
               Surface(color = MaterialTheme.colors.background) {
                   val navController = rememberNavController()
                   NavHost(
                       navController = navController,
                       startDestination = Screens.Home.route)
                   {
                        composable(route = Screens.Home.route) {
                            Home(navController = navController, viewModel = HomeViewModel(baseContext))
                        }
                   }
               }
            }
        }
    }

    @Composable
    fun Greetings() {
        Text(text = "Hello, Migrating to KMM")
    }

}
