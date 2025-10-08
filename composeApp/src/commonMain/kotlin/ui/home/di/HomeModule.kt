package ui.home.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ui.home.HomeViewModel

val homeModule = module {
    viewModelOf(::HomeViewModel)
}