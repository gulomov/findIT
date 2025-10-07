package data.feature.recommendations.remote

import data.feature.recommendations.converter.RecommendationResponseConverter
import data.feature.recommendations.remote.response.RecommendationsResponse
import dev.gitlive.firebase.database.FirebaseDatabase
import domain.RecommendationList
import firebase.fetchOnceFromRealTimeDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flowOn

internal class RecommendationsRemoteDataSourceImpl(
    private val firebaseDatabase: FirebaseDatabase,
    private val converter: RecommendationResponseConverter
) : RecommendationsRemoteDataSource {

    override suspend fun getRecommendationsList(): RecommendationList =
        converter.toDomain(
            fetchOnceFromRealTimeDatabase<RecommendationsResponse>(
                "home/recommendations",
                firebaseDatabase
            )
                .flowOn(Dispatchers.IO)
                .firstOrNull() ?: RecommendationsResponse(emptyList())
        )
}