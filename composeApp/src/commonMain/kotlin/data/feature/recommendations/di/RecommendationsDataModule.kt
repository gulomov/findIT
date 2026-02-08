package data.feature.recommendations.di

import data.feature.recommendations.RecommendationsRepository
import data.feature.recommendations.RecommendationsRepositoryImpl
import data.feature.recommendations.local.RecommendationsLocalDataSource
import data.feature.recommendations.local.RecommendationsLocalDataSourceImpl
import data.feature.recommendations.remote.RecommendationsRemoteDataSource
import data.feature.recommendations.remote.RecommendationsRemoteDataSourceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val recommendationsDataModule = module {
    singleOf(::RecommendationsRemoteDataSourceImpl) bind RecommendationsRemoteDataSource::class
    singleOf(::RecommendationsLocalDataSourceImpl) bind RecommendationsLocalDataSource::class
    singleOf(::RecommendationsRepositoryImpl) bind RecommendationsRepository::class
}