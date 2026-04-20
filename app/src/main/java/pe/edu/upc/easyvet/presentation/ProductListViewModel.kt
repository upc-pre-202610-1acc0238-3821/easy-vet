package pe.edu.upc.easyvet.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import pe.edu.upc.easyvet.data.ProductRepositoryImpl
import pe.edu.upc.easyvet.domain.Product

class ProductListViewModel (val productRepository: ProductRepositoryImpl): ViewModel() {
    private var _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> get() = _products
}