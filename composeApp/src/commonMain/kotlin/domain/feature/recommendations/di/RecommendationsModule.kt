package domain.feature.recommendations.di

import domain.feature.recommendations.GetRecommendationsUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val recommendationsModule = module {
    factoryOf(::GetRecommendationsUseCase)
}