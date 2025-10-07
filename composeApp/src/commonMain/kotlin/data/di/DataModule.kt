package data.di

import data.feature.recommendations.di.recommendationsModule
import org.koin.dsl.module

val dataModule = module {
    listOf(
        recommendationsModule
    )
}