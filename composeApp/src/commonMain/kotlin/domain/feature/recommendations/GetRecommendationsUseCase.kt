package domain.feature.recommendations

import data.feature.recommendations.RecommendationsRepository
import domain.feature.recommendations.model.Recommendation
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetRecommendationsUseCase : KoinComponent {
    val recommendationsRepository: RecommendationsRepository by inject()
    suspend operator fun invoke() = recommendationsRepository.getRecommendations()
}