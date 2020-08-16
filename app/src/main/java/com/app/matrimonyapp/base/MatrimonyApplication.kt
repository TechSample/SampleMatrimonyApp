package com.app.matrimonyapp.base

import android.app.Application
import com.facebook.stetho.Stetho

class MatrimonyApplication : Application() {

    companion object {
        lateinit var instance: MatrimonyApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        Stetho.initializeWithDefaults(this)
    }
}

