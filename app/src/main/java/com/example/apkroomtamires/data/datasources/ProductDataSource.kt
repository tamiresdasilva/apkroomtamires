package com.example.apkroomtamires.data.datasources

import com.example.apkroomtamires.data.database.ProductDao
import com.example.apkroomtamires.data.database.ProductEntity
import javax.inject.Inject

class ProductDataSource @Inject constructor(private val productDao: ProductDao) {
    fun fetchAllProducts(): List<ProductEntity> = productDao.fetchAllProducts()
    suspend fun adicionarProduto(productEntity: ProductEntity) = productDao.adicionarProduto(productEntity)

    suspend fun removeProduto(produtoNome: String) = productDao.removeProduto(produtoNome)
}