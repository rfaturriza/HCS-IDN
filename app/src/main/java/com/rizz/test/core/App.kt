package com.rizz.test.core

import android.app.Application
import com.rizz.test.core.persistence.DatabaseClient
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        DatabaseClient.init(this)
    }
}