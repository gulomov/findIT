package domain.feature.news.model

import kotlinx.serialization.Serializable

@Serializable
data class NewsInfo(
    val newsList: List<NewsItem>? = emptyList(),
    val title: String,
)

@Serializable
data class NewsItem(
    val id: Int,
    val image: String,
    val body: String,
    val title: String,
)