package com.emma_ea.hellokmm.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emma_ea.hellokmm.Greeting
import android.widget.TextView
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

suspend fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {

    private val scope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = getString(R.string.loader_text)

        scope.launch {
            kotlin.runCatching {
                greet()
            }.onSuccess {
                tv.text = it
            }.onFailure {
                tv.text = it.localizedMessage
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }
}
