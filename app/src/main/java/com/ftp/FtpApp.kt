package com.ftp

import android.app.Application
import com.ftp.di.apiModule
import com.ftp.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class FtpApp : Application() {

    override fun onCreate() {
        super.onCreate()

        val appModules: MutableList<Module> = ArrayList()
        appModules.add(networkModule)
        appModules.addAll(apiModule)

        startKoin {
            androidContext(this@FtpApp)
            modules(appModules)
        }
    }
}