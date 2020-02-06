package com.jamadev.cityflagtest

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    private val modules = listOf(appModule, networkModule, appListModule)

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(modules)
        }
    }

}