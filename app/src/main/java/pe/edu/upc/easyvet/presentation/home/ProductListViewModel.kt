package pe.edu.upc.easyvet.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pe.edu.upc.easyvet.domain.repository.ProductRepository
import pe.edu.upc.easyvet.presentation.home.UiState

class ProductListViewModel(
    private val productRepository: ProductRepository
) : ViewModel() {
    private var _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> get() = _state

    fun getProducts() {

        _state.update {
            it.copy(isLoading = true)
        }

        viewModelScope.launch {
            try {
                val products = productRepository.getProducts()
                _state.update {
                    it.copy(isLoading = false, products = products)
                }

            } catch (e: Exception) {
                _state.update {
                    it.copy(isLoading = false, errorMessage = e.message)
                }
            }
        }

    }

    init {
        getProducts()
    }

}