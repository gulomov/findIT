package navigation

import kotlinx.serialization.Serializable

@Serializable
object Introduction

@Serializable
object HomeScreen

@Serializable
data object FavoriteScreen

@Serializable
data class ProductDetailScreen(
    val productId: String
)

@Serializable
data class NewsDetailsScreen(
    val newsId: String
)

@Serializable
data class RecommendationDetailsScreen(
    val newsId: String
)

@Serializable
data class GalleryScreen(
    val newsId: String
)
