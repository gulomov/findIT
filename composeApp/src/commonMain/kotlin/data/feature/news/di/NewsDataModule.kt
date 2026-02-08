package data.feature.news.di

import data.feature.news.NewsRepository
import data.feature.news.NewsRepositoryImpl
import data.feature.news.remote.NewsRemoteDataSource
import data.feature.news.remote.NewsRemoteDataSourceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val newsDataModule = module {
    singleOf(::NewsRemoteDataSourceImpl) bind NewsRemoteDataSource::class
    singleOf(::NewsRepositoryImpl) bind NewsRepository::class
}