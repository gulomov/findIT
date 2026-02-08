package feature.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import domain.feature.recommendations.model.Recommendation

@Composable
fun RecommendationItem(
    recommendation: Recommendation,
    modifier: Modifier = Modifier,
    onItemClick: () -> Unit
) {
    Card(
        modifier = modifier.clickable(
            onClick = onItemClick
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            ProductImage(recommendation.image)
            Text(
                text = recommendation.brand
            )
        }
    }
}