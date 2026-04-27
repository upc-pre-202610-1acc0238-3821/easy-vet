package pe.edu.upc.easyvet.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.upc.easyvet.di.RepositoryModule.provideProductRepository
import pe.edu.upc.easyvet.domain.model.Product
import pe.edu.upc.easyvet.presentation.home.ProductDetail
import pe.edu.upc.easyvet.presentation.home.ProductList
import pe.edu.upc.easyvet.presentation.home.ProductListViewModel
import pe.edu.upc.easyvet.presentation.home.ProductListViewModelFactory


@Composable
fun Navigation() {
    val factory = ProductListViewModelFactory(provideProductRepository())
    val viewModel: ProductListViewModel = viewModel(factory = factory)

    val selectedProduct = remember {
        mutableStateOf<Product?>(null)
    }

    Scaffold { paddingValues ->
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable ("home") {
                ProductList(viewModel) { product ->
                    selectedProduct.value = product
                    navController.navigate("product_detail")
                }
            }

            composable ("product_detail") {
                selectedProduct.value?.let { product ->
                    ProductDetail(product)
                }

            }
        }
    }
}