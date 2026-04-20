package pe.edu.upc.easyvet.data

import pe.edu.upc.easyvet.domain.Product

class ProductRepository(
    val productService: ProductService
) {
    suspend fun getProducts(): List<Product> {

        val response = productService.getProducts()

        if (response.isSuccessful) {
            response.body()?.let {
                return it.products
            }
        }
        return emptyList()
    }
}