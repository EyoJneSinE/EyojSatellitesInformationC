package com.eniskaner.eyojsatellitesinformation

import android.app.Application
import com.eniskaner.eyojsatellitesinformation.di.initKoin
import org.koin.android.ext.koin.androidContext

class SatelliteApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@SatelliteApplication)
        }
    }
}
