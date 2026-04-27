package pe.edu.upc.easyvet.data.remote

import com.google.gson.annotations.SerializedName

data class ProductDto (
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val image: String,
    val rating: Double,
    val category: String,
    val stock: Int
)

data class ProductsDto (
    val count: Int,
    @SerializedName("results")
    val products: List<ProductDto>
)