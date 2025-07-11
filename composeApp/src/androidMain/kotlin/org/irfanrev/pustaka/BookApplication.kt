package org.irfanrev.pustaka

import android.app.Application
import org.irfanrev.pustaka.di.initKoin
import org.koin.android.ext.koin.androidContext

class BookApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@BookApplication)
        }
    }

}