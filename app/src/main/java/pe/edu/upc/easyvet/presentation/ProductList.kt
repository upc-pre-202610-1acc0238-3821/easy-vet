package pe.edu.upc.easyvet.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier

@Composable
fun ProductList(viewModel: ProductListViewModel, modifier: Modifier){

    val products = viewModel.products.collectAsState()

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        LazyColumn {
            items(products.value){ product ->
                ProductCard(product)
            }
        }

    }

}