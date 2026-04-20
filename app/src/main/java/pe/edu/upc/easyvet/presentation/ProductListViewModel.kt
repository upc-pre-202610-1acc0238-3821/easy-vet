package pe.edu.upc.easyvet.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.upc.easyvet.domain.Product
import pe.edu.upc.easyvet.domain.ProductRepository

class ProductListViewModel(
    private val productRepository: ProductRepository
) : ViewModel() {
    private var _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> get() = _products

    fun getProducts() {
        viewModelScope.launch {
           _products.value = productRepository.getProducts()
        }

    }

}