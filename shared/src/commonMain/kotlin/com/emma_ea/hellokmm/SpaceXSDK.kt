package com.emma_ea.hellokmm

import com.emma_ea.hellokmm.entity.RocketLaunch
import com.emma_ea.hellokmm.network.SpaceXApi
import com.emma_ea.hellokmm.sqldelight.Database
import com.emma_ea.hellokmm.sqldelight.DatabaseDriverFactory

class SpaceXSDK(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = Database(databaseDriverFactory)
    private val api = SpaceXApi()

    @Throws(Exception::class)
    suspend fun getLaunches(forceReload: Boolean): List<RocketLaunch> {
        val cachedLaunches = database.getAllLaunches()
        return if (cachedLaunches.isNotEmpty() && !forceReload) {
            cachedLaunches
        } else {
            api.getAllLaunches().also {
                database.clearDatabase()
                database.createLaunches(it)
            }
        }
    }
}