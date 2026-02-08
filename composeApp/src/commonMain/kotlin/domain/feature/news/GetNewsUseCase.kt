package domain.feature.news

import data.feature.news.NewsRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetNewsUseCase : KoinComponent {
    val newsRepository: NewsRepository by inject()
    suspend operator fun invoke() = newsRepository.getNews()
}
