package domain.feature.recommendations

import domain.feature.recommendations.model.Recommendation
import kotlinx.coroutines.flow.Flow

interface RecommendationsRepository {
    suspend fun getRecommendations(): Flow<List<Recommendation>>
    suspend fun saveRecommendation(recommendation: Recommendation)
}