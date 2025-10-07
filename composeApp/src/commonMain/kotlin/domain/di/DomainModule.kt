package domain.di

import domain.feature.recommendations.di.recommendationsModule
import org.koin.dsl.module

val domainModule = module {
    listOf(recommendationsModule)
}