package domain

import kotlinx.serialization.Serializable

@Serializable
data class RecommendationList(
    val recommendationsList: List<RecommendationItem>,
)

@Serializable
data class RecommendationItem(
    val id: Int,
    val image: String,
    val brand: String
)
