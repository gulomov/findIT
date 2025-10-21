package data.feature.recommendations.local

import domain.feature.recommendations.model.Recommendation

interface RecommendationsLocalDataSource {
    suspend fun saveRecommendations(recommendations: List<Recommendation>)
}