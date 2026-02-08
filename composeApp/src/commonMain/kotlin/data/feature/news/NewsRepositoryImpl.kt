package data.feature.news

import data.feature.news.remote.NewsRemoteDataSource
import domain.feature.news.model.NewsItem
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    private val remote: NewsRemoteDataSource
) : NewsRepository {
    override suspend fun getNews(): Flow<List<NewsItem>> = remote.getNews()
}