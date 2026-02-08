package data.di

import data.feature.news.di.newsDataModule
import data.feature.recommendations.di.recommendationsDataModule
import org.koin.dsl.module

val dataModule = module {
    includes(recommendationsDataModule,newsDataModule)
}