package domain.feature.recommendations

import domain.RecommendationList

interface RecommendationsRepository {
    suspend fun getRecommendations(): RecommendationList
}