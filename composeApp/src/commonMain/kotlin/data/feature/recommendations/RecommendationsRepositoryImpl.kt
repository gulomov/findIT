package data.feature.recommendations

import data.feature.recommendations.local.RecommendationsLocalDataSource
import data.feature.recommendations.remote.RecommendationsRemoteDataSource
import domain.feature.recommendations.model.Recommendation
import domain.feature.recommendations.RecommendationsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

class RecommendationsRepositoryImpl(
    private val remote: RecommendationsRemoteDataSource,
    private val local: RecommendationsLocalDataSource
) : RecommendationsRepository {
    override suspend fun getRecommendations(): Flow<List<Recommendation>> =
        remote.getRecommendationsList().onEach {
            local.saveRecommendations(it)
        }
}

