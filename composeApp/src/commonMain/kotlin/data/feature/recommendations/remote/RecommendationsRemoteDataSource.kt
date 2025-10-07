package data.feature.recommendations.remote

import domain.RecommendationList

interface RecommendationsRemoteDataSource {
    suspend fun getRecommendationsList(): RecommendationList
}