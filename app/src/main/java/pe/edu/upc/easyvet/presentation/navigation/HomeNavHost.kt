package pe.edu.upc.easyvet.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.upc.easyvet.domain.model.Product
import pe.edu.upc.easyvet.presentation.home.ProductDetail
import pe.edu.upc.easyvet.presentation.home.ProductList
import pe.edu.upc.easyvet.presentation.home.ProductListViewModel


@Composable
fun HomeNavHost() {
    val viewModel: ProductListViewModel = viewModel()

    val selectedProduct = remember {
        mutableStateOf<Product?>(null)
    }

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            ProductList(viewModel) { product ->
                selectedProduct.value = product
                navController.navigate("product_detail")
            }
        }

        composable("product_detail") {
            selectedProduct.value?.let { product ->
                ProductDetail(product)
            }


        }
    }
}