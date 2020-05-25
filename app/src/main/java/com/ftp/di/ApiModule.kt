package com.ftp.di

import org.koin.core.module.Module
import org.koin.dsl.module

val loginApiModule = module {
    // contains factories of Login, Registration, VerifyOTP API interfaces
//    factory { provideLoginApi(retrofit = get()) }  //Login
}

/*private fun provideLoginApi(retrofit: Retrofit): LoginApi =
    retrofit.create(LoginApi::class.java)*/

val apiModule: List<Module> = listOf(
    // includes list of different Modules of apis eg. Login, Categories, Product api modules
    loginApiModule
)
