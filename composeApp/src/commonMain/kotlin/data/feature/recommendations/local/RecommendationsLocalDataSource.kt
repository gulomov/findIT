package data.feature.recommendations.local

import domain.RecommendationList

interface RecommendationsLocalDataSource {
    suspend fun saveRecommendations(recommendations: RecommendationList)
}