package domain.di

import domain.feature.news.di.newsDomainModule
import domain.feature.recommendations.di.recommendationsDomainModule
import org.koin.dsl.module

val domainModule = module {
    includes(recommendationsDomainModule, newsDomainModule)
}