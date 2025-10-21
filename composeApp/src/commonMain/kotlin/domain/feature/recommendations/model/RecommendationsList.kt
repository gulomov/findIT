package domain.feature.recommendations.model

import kotlinx.serialization.Serializable

@Serializable
data class Recommendation(
    val id: Int? = null,
    val image: String? = null,
    val brand: String? = null
)