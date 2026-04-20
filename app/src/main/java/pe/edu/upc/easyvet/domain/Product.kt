package pe.edu.upc.easyvet.domain

data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val image: String
)

data class ProductsResponse(
    val products: List<Product>
)