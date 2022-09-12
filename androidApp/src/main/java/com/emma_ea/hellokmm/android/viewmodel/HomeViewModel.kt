package com.emma_ea.hellokmm.android.viewmodel

import android.app.Application
import android.content.Context
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.emma_ea.hellokmm.SpaceXSDK
import com.emma_ea.hellokmm.entity.RocketLaunch
import com.emma_ea.hellokmm.sqldelight.DatabaseDriverFactory
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class HomeViewModel(ctx: Context) : ViewModel() {

    private val _launches = SpaceXSDK(DatabaseDriverFactory(ctx))

    private var _rockets = mutableStateListOf<RocketLaunch>()

//    private var _swipeRefreshState: Boolean = false
//    val swipeState: Boolean get() = _swipeRefreshState

    init {
        refreshList(true)
    }

    fun refreshList(r: Boolean) {
        viewModelScope.launch {
            kotlin.runCatching {
//                _swipeRefreshState = true
                _launches.getLaunches(true)
            }.onSuccess {
//                _swipeRefreshState = false
                _rockets.addAll(it)
            }.onFailure {
//                _swipeRefreshState = false
                print(it)
            }
        }
    }

    fun getLaunches(): List<RocketLaunch> {
        return _rockets
    }

}
