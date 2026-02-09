package data.feature.news

import domain.feature.news.model.NewsItem

interface NewsRepository {
    suspend fun getNews(): List<NewsItem>
}