package data.feature.recommendations

import data.feature.recommendations.remote.RecommendationsRemoteDataSource
import data.feature.recommendations.local.RecommendationsLocalDataSourceImpl
import domain.RecommendationList
import domain.feature.recommendations.RecommendationsRepository

class RecommendationsRepositoryImpl(
    private val remote: RecommendationsRemoteDataSource,
    private val local: RecommendationsLocalDataSourceImpl
) : RecommendationsRepository {
    override suspend fun getRecommendations(): RecommendationList =
        remote.getRecommendationsList().also {
            local.saveRecommendations(it)
        }
}

