package database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import database.entity.RecommendationEntity
import domain.feature.recommendations.model.Recommendation
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductsDao {
    @Query("SELECT * from recommendation")
    fun getRecommendations(): Flow<List<Recommendation>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecommendations(
        items: List<RecommendationEntity>
    )

}