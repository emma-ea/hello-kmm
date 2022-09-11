package com.emma_ea.hellokmm.sqldelight

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
         return NativeSqliteDriver(AppDatabase.Schema, "test.db")
    }
}
