package com.example.apkroomtamires.data

import com.example.apkroomtamires.data.database.ProductEntity
import java.io.Serializable

data class Produto(
    val urlImagem: String,
    val nome: String,
    val preco: String
) : Serializable

fun Produto.mapperToEntity() =
    ProductEntity(nome = this.nome, preco = this.preco, urlImagem = this.urlImagem)