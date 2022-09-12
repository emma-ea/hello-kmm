package com.emma_ea.hellokmm.android.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.emma_ea.hellokmm.entity.RocketLaunch

@Composable
fun LaunchInfo(launch: RocketLaunch) {
    Card(modifier = Modifier.fillMaxWidth().padding(horizontal = 5.dp, vertical = 5.dp),
        elevation = 6.dp,
    )
    {
        Column(modifier = Modifier.padding(5.dp)) {
            Text(text = launch.missionName)
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = launch.rocket.name)
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = launch.launchYear.toString())
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = launch.details ?: "")
        }
    }
}

