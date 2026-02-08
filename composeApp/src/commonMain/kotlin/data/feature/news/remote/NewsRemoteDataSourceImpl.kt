package data.feature.news.remote

import domain.feature.news.model.NewsItem
import kotlinx.coroutines.flow.Flow
import listenToList

class NewsRemoteDataSourceImpl : NewsRemoteDataSource {
    override suspend fun getNews(): Flow<List<NewsItem>> {
        val newsFlow = listenToList(
            path = "home/news",
            arrayKey = "newsList",
            deserializer = NewsItem.serializer()
        )
        return newsFlow
    }
}