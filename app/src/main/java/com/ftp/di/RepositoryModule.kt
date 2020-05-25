package com.ftp.di

import com.ftp.data.dashboard.repository.CategoryRemoteDataSource
import com.ftp.data.dashboard.repository.CategoryRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val dashboardRepoModules = module {
    factory { CategoryRemoteDataSource(categoryApi = get()) }
    factory { CategoryRepository(remoteDataSource = get()) }
}

val repositoryModules: List<Module> = listOf(
    dashboardRepoModules
)