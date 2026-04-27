package pe.edu.upc.easyvet.data.repository

import pe.edu.upc.easyvet.data.remote.ProductService
import pe.edu.upc.easyvet.domain.model.Product
import pe.edu.upc.easyvet.domain.repository.ProductRepository

class ProductRepositoryImpl(
    val productService: ProductService
) : ProductRepository {

    override suspend fun getProducts(): List<Product> {
        val response = productService.getProducts()

        if (response.isSuccessful) {
            response.body()?.let { productsDto ->
                return productsDto.products.map { productDto ->
                    Product(
                        id = productDto.id,
                        name = productDto.title,
                        price = productDto.price,
                        description = productDto.description,
                        image = productDto.image
                    )
                }
            }
        }
        return emptyList()
    }

}