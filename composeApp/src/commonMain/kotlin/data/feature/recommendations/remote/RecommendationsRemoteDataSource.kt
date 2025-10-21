package data.feature.recommendations.remote

import domain.feature.recommendations.model.Recommendation
import kotlinx.coroutines.flow.Flow

interface RecommendationsRemoteDataSource {
    suspend fun getRecommendationsList(): Flow<List<Recommendation>>
}