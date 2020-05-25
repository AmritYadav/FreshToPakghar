package com.ftp.di

import com.ftp.data.dashboard.api.CategoryApi
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

val loginApiModules = module {
    // contains factories of Login, Registration, VerifyOTP API interfaces
//    factory { provideLoginApi(retrofit = get()) }  //Login
}

val dashboardApiModules = module {
    factory { provideCategoryApi(retrofit = get()) }
}

/*private fun provideLoginApi(retrofit: Retrofit): LoginApi =
    retrofit.create(LoginApi::class.java)*/
private fun provideCategoryApi(retrofit: Retrofit): CategoryApi =
    retrofit.create(CategoryApi::class.java)

val apiModules: List<Module> = listOf(
    loginApiModules,
    dashboardApiModules
)
