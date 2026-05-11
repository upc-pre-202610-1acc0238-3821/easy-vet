package pe.edu.upc.easyvet.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pe.edu.upc.easyvet.domain.repository.ProductRepository
import pe.edu.upc.easyvet.presentation.home.UiState
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {
    val state = MutableStateFlow(UiState())

    fun observeProducts() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                productRepository.getProducts().collect { products ->
                    state.update {
                        it.copy(products = products)
                    }
                }
            }
        }
    }

    fun syncProducts() {

        state.update {
            it.copy(isLoading = true)
        }

        viewModelScope.launch {
            try {
                productRepository.syncProducts()
                state.update {
                    it.copy(isLoading = false)
                }

            } catch (_: UnknownHostException) {
                state.update {
                    it.copy(isLoading = false, errorMessage = "No internet connection")
                }
            } catch (e: Exception) {
                state.update {
                    it.copy(isLoading = false, errorMessage = e.message ?: "An error occurred")
                }
            }
        }

    }

    fun clearError() {
        state.update {
            it.copy(errorMessage = null)
        }
    }

    init {
        observeProducts()
        syncProducts()
    }

}