package com.example.apkroomtamires.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface ProductDao {
    @Query("SELECT * FROM produtos")
    fun fetchAllProducts(): List<ProductEntity>

    @Insert
    suspend fun adicionarProduto(productEntity: ProductEntity)

    @Query("Delete from produtos where nome = :produtoNome")
    suspend fun removeProduto(produtoNome: String)

}