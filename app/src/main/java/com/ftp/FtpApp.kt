package com.ftp

import android.app.Application
import com.ftp.di.apiModules
import com.ftp.di.networkModule
import com.ftp.di.repositoryModules
import com.ftp.di.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class FtpApp : Application() {

    override fun onCreate() {
        super.onCreate()

        val appModules: MutableList<Module> = ArrayList()
        appModules.add(networkModule)
        appModules.addAll(apiModules)
        appModules.addAll(viewModelModules)
        appModules.addAll(repositoryModules)

        startKoin {
            androidContext(this@FtpApp)
            modules(appModules)
        }
    }
}