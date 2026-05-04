package pe.edu.upc.easyvet.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Query("select * from products")
    fun getProducts(): Flow<List<ProductEntity>>

    @Insert
    suspend fun insertProducts(products: List<ProductEntity>)

    @Query("delete from products")
    suspend fun deleteAllProducts()

}