package com.emma_ea.hellokmm.android

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.emma_ea.hellokmm.android.components.LaunchInfo
import com.emma_ea.hellokmm.entity.Links
import com.emma_ea.hellokmm.entity.Rocket
import com.emma_ea.hellokmm.entity.RocketLaunch

@Preview("greetings")
@Composable
fun Previews() {
    Greetings()
}

@Composable
fun Greetings() {
    Text(text = "Hello, Migrating to Compose")
}

@Preview("Launch Card")
@Composable
fun LaunchCard() {
    LaunchInfo(launch =
        RocketLaunch(
            1,
            "mission",
            2014,
            "date",
            Rocket("id", "name", "type"),
            "details",
            true,
            Links("missionPatchUrl", "articleUrl")
        )
    )
}