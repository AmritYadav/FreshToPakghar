package com.ftp.di

import android.content.Context
import android.content.SharedPreferences
import com.ftp.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { provideSharedPreference(androidApplication()) }
    factory { provideLoggingInterceptor() }
    factory { provideOkHttpClient(logging = get()) }
    single { provideRetrofit(okHttpClient = get()) }
}

private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BuildConfig.FTP_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

private fun provideLoggingInterceptor(): HttpLoggingInterceptor {
    val logging = HttpLoggingInterceptor()
    if (BuildConfig.DEBUG)
        logging.level = (HttpLoggingInterceptor.Level.BODY)
    return logging
}

private fun provideOkHttpClient(
    logging: HttpLoggingInterceptor
): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(logging)
//        .addInterceptor(clientAuthInterceptor) //Todo: class that will have token
        .connectTimeout(60, TimeUnit.SECONDS)
        .build()
}

private fun provideSharedPreference(context: Context): SharedPreferences {
    return context.getSharedPreferences("LOGIN_PREFERENCE", Context.MODE_PRIVATE)
}