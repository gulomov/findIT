package data.feature.news.remote

import domain.feature.news.model.NewsItem
import kotlinx.coroutines.flow.Flow

interface NewsRemoteDataSource {
    suspend fun getNews(): Flow<List<NewsItem>>
}