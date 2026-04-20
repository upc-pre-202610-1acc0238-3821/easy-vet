package pe.edu.upc.easyvet.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pe.edu.upc.easyvet.domain.Product

@Composable
fun ProductCard(product: Product) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Column(modifier = Modifier.padding(8.dp)) {

            AsyncImage(
                model = product.image,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )
            Text(product.title, fontWeight = FontWeight.Bold)
            Text(product.description, maxLines = 2)
        }
    }
}