package com.ftp.di

import com.ftp.ui.dashboard.CategoryViewModel
import com.ftp.ui.grocery.ProductsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val dashboardViewModelModule = module {
    viewModel { CategoryViewModel(categoryRepository = get()) }
}

val productViewModelModule = module {
    viewModel { ProductsViewModel(productsRepository = get()) }
}

val viewModelModules: List<Module> = listOf(
    dashboardViewModelModule,
    productViewModelModule
)
