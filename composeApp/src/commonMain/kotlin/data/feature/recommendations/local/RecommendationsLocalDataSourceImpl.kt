package data.feature.recommendations.local

import database.AppDatabase
import domain.feature.recommendations.model.Recommendation
import kotlinx.coroutines.flow.Flow

class RecommendationsLocalDataSourceImpl(
    private val database: AppDatabase
) : RecommendationsLocalDataSource {
    override suspend fun saveRecommendations(recommendations: List<Recommendation>) {
        val entities = recommendations.map { it.toEntity() }
        database.productsDao().insertRecommendations(entities)
    }

    override fun getRecommendations(): Flow<List<Recommendation>> {
        return database.productsDao().getRecommendations()
    }
}