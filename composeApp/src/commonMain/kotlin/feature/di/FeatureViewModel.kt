package feature.di

import org.koin.dsl.module

val featureViewModel = module {
    includes(viewModelModule)
}