package com.ftp.di

import com.ftp.data.dashboard.api.CategoryApi
import com.ftp.data.product.api.ProductApi
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

val productApiModule = module {
    factory { provideProductApi(retrofit = get()) }
}

/*private fun provideLoginApi(retrofit: Retrofit): LoginApi =
    retrofit.create(LoginApi::class.java)*/
private fun provideCategoryApi(retrofit: Retrofit): CategoryApi =
    retrofit.create(CategoryApi::class.java)

private fun provideProductApi(retrofit: Retrofit): ProductApi =
    retrofit.create(ProductApi::class.java)

val apiModules: List<Module> = listOf(
    loginApiModules,
    dashboardApiModules,
    productApiModule
)
