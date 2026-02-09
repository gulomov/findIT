package data.feature.news

import data.feature.news.remote.NewsRemoteDataSource
import domain.feature.news.model.NewsItem

class NewsRepositoryImpl(
    private val remote: NewsRemoteDataSource
) : NewsRepository {
    override suspend fun getNews(): List<NewsItem> {
        return remote.getNews()
    }
}