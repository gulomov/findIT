package data.feature.recommendations

import domain.feature.recommendations.model.Recommendation
import kotlinx.coroutines.flow.Flow

interface RecommendationsRepository {
    suspend fun getRecommendations(): Flow<List<Recommendation>>
}