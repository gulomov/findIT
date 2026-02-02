package domain.feature.recommendations.model

import database.entity.RecommendationEntity
import kotlinx.serialization.Serializable

@Serializable
data class Recommendation(
    val id: Int,
    val image: String,
    val brand: String
){
    fun toEntity() = RecommendationEntity(
        id = id,
        image = image,
        brand = brand
    )
}