package data.feature.recommendations.local

import domain.RecommendationList

class RecommendationsLocalDataSourceImpl:RecommendationsLocalDataSource {
    override suspend fun saveRecommendations(recommendations: RecommendationList) {
        // TODO: Save to database
    }
}