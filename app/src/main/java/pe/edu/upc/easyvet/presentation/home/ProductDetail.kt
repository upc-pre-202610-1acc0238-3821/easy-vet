package pe.edu.upc.easyvet.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil3.compose.AsyncImage
import pe.edu.upc.easyvet.domain.model.Product

@Composable
fun ProductDetail(product: Product) {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            AsyncImage(model = product.image, contentDescription = product.name)
            Text(text = product.name)
            Text(text = "$ ${product.price}")
        }
    }

}