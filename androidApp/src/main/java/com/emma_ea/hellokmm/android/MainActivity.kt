package com.emma_ea.hellokmm.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import com.emma_ea.hellokmm.Greeting
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.emma_ea.hellokmm.SpaceXSDK
import com.emma_ea.hellokmm.sqldelight.DatabaseDriverFactory
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val scope = MainScope()

    private lateinit var launchesRecyclerView: RecyclerView
    private lateinit var progressBarView: FrameLayout
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var pullToRefreshTv: TextView

    private val launchesRvAdapter = LaunchesRvAdapter(listOf())

    private val sdk = SpaceXSDK(DatabaseDriverFactory(this))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "SpaceX Launches"

        initViews()

        launchesRecyclerView.adapter = launchesRvAdapter
        launchesRecyclerView.layoutManager = LinearLayoutManager(this)

        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = false
            displayLaunches(true)
        }
        displayLaunches(false)

        pullToRefreshTv.isVisible = false

        // TODO: not working
        if (launchesRvAdapter.launches.isEmpty()) {
            pullToRefreshTv.isVisible = true
        }

    }

    private fun initViews() {
        launchesRecyclerView = findViewById(R.id.launchesListRv)
        progressBarView = findViewById(R.id.progressBar)
        swipeRefreshLayout = findViewById(R.id.swipeContainer)
        pullToRefreshTv = findViewById(R.id.pull_to_refresh_notif)
    }

    private fun displayLaunches(needReload: Boolean) {
        progressBarView.isVisible = true
        pullToRefreshTv.isVisible = true
        pullToRefreshTv.text = "Refreshing..."
        scope.launch {
            kotlin.runCatching {
                sdk.getLaunches(needReload)
            }.onSuccess {
                launchesRvAdapter.launches = it
                launchesRvAdapter.notifyDataSetChanged()
            }.onFailure {
                Toast.makeText(this@MainActivity, it.localizedMessage, Toast.LENGTH_SHORT).show()
            }
            progressBarView.isVisible = false
            pullToRefreshTv.isVisible = false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }

}
