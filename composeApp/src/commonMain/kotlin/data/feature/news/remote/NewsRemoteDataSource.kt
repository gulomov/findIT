package data.feature.news.remote

import domain.feature.news.model.NewsItem

interface NewsRemoteDataSource {
    suspend fun getNews(): List<NewsItem>
}