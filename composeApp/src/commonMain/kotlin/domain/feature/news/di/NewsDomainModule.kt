package domain.feature.news.di

import domain.feature.news.GetNewsUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val newsDomainModule = module {
    factoryOf(::GetNewsUseCase)
}