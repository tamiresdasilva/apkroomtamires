package com.example.apkroomtamires.data.repositories

import com.example.apkroomtamires.data.Produto
import com.example.apkroomtamires.data.database.mapperToProduct
import com.example.apkroomtamires.data.datasources.ProductDataSource
import com.example.apkroomtamires.data.mapperToEntity
import javax.inject.Inject

class ProdutoRepository @Inject constructor(private val productDataSource: ProductDataSource) {
    fun fetchAllProducts(): List<Produto> {
        return productDataSource
            .fetchAllProducts()
            .map { item -> item.mapperToProduct() }
    }

    suspend fun adicionarProduto(produto: Produto) {
        productDataSource.adicionarProduto(produto.mapperToEntity())
    }

    suspend fun removeProduto(produto: Produto) {
        productDataSource.removeProduto(produto.nome)
    }
}