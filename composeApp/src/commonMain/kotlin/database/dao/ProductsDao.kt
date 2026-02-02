package database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import database.entity.RecommendationEntity
import domain.feature.recommendations.model.Recommendation

@Dao
interface ProductsDao {
    @Query("SELECT * from recommendation")
    suspend fun getRecommendations(): Recommendation

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecommendations(
        items: List<RecommendationEntity>
    )

}