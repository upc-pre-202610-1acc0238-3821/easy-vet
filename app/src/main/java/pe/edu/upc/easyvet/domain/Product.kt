package pe.edu.upc.easyvet.domain

data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val description: String,
    val image: String
)