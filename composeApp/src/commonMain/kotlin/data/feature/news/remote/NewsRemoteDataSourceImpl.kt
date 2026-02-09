package data.feature.news.remote

import domain.feature.news.model.NewsItem
import listenToList

class NewsRemoteDataSourceImpl : NewsRemoteDataSource {
    override suspend fun getNews(): List<NewsItem> {
        return listenToList(
            path = "home/news",
            arrayKey = "newsList",
            deserializer = NewsItem.serializer()
        )
    }
}