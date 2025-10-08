package ui.di

import org.koin.dsl.module
import ui.home.di.homeModule

val featureViewModel = module {
    includes(homeModule)
}