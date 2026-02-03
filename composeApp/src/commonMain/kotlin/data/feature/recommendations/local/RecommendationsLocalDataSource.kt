package data.feature.recommendations.local

import domain.feature.recommendations.model.Recommendation
import kotlinx.coroutines.flow.Flow

interface RecommendationsLocalDataSource {
    suspend fun saveRecommendations(recommendations: List<Recommendation>)

    fun getRecommendations(): Flow<List<Recommendation>>
}