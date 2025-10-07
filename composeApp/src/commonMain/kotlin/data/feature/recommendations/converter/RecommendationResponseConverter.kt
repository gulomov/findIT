package data.feature.recommendations.converter

import data.feature.recommendations.remote.response.RecommendationsResponse
import domain.RecommendationItem
import domain.RecommendationList

internal class RecommendationResponseConverter {
    fun toDomain(response: RecommendationsResponse): RecommendationList =
        RecommendationList(
            recommendationsList = response.recommendationsList.map {
                RecommendationItem(
                    id = it.id,
                    image = it.image,
                    brand = it.brand
                )
            }
        )
}