package dev.tutorial.kmmargherita.android

import android.app.Application
import dev.tutorial.kmmargherita.di.initKoin

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {}
    }
}
