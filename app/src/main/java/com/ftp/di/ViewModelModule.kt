package com.ftp.di

import com.ftp.ui.dashboard.CategoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val dashboardViewModelModule = module {
    viewModel { CategoryViewModel(categoryRepository = get()) }
}

val viewModelModules: List<Module> = listOf(
    dashboardViewModelModule
)