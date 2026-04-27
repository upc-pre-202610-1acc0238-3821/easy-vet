package pe.edu.upc.easyvet.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import pe.edu.upc.easyvet.domain.model.Product

@Composable
fun ProductList(
    viewModel: ProductListViewModel,
    modifier: Modifier = Modifier,
    onProductClick: (Product) -> Unit
) {

    val state = viewModel.state.collectAsState().value

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when {
            (state.isLoading) -> CircularProgressIndicator()
            (state.errorMessage != null) -> Text(state.errorMessage)
            (state.products.isEmpty()) -> Text("No products found")
            else ->
                LazyColumn {
                    items(state.products) { product ->
                        ProductItem(product) {
                            onProductClick(product)
                        }
                    }
                }
        }


    }

}