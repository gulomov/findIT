package database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recommendation")
data class RecommendationEntity(
    @PrimaryKey val id: Int,
    val image: String,
    val brand: String
)
