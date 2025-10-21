package data.feature.recommendations.local

import domain.feature.recommendations.model.Recommendation

class RecommendationsLocalDataSourceImpl : RecommendationsLocalDataSource {
    override suspend fun saveRecommendations(recommendations: List<Recommendation>) {
        // TODO: Save to database
    }
}