package data.feature.recommendations.remote

import domain.feature.recommendations.model.Recommendation
import kotlinx.coroutines.flow.Flow
import listenToList

internal class RecommendationsRemoteDataSourceImpl() : RecommendationsRemoteDataSource {

    override suspend fun getRecommendationsList(): Flow<List<Recommendation>> {
        val recommendationsFlow = listenToList(
            path = "home/recommendations",
            arrayKey = "recommendationsList",
            deserializer = Recommendation.serializer()
        )
        return recommendationsFlow
    }
}