package pe.edu.upc.easyvet.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {

    @Query("select * from products")
    suspend fun getProducts(): List<ProductEntity>

    @Insert
    suspend fun insertProducts(vararg products: ProductEntity)

    @Delete
    suspend fun deleteProducts(vararg products: ProductEntity)

}