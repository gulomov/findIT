package data.feature.recommendations.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class RecommendationsResponse(
    @SerialName("recommendationsList")
    val recommendationsList: List<RecommendationItemResponse>,
)


@Serializable
data class RecommendationItemResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("image")
    val image: String,
    @SerialName("brand")
    val brand: String
)
