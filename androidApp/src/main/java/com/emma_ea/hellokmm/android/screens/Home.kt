package com.emma_ea.hellokmm.android.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.emma_ea.hellokmm.android.components.LaunchInfo
import com.emma_ea.hellokmm.android.viewmodel.HomeViewModel
import com.emma_ea.hellokmm.entity.RocketLaunch



@Composable
fun Home(navController: NavController, viewModel: HomeViewModel) {

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "SpaceX Launches") }) },
        content = { padding ->
            Box(
                modifier =
                Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                Body(viewModel.getLaunches())
            }
        }
    )
}

@Composable
fun Body(launches: List<RocketLaunch>) {

    if (launches.isEmpty()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "Loading ...")
        }
    } else {
        LazyColumn {
            items(launches.size) { item ->
                LaunchInfo(launch = launches[item])
            }
        }
    }
}

