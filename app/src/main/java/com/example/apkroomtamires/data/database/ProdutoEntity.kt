package com.example.apkroomtamires.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.apkroomtamires.data.Produto

@Entity(tableName = "produtos")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nome: String,
    val preco: String,
    val urlImagem: String
)

fun ProductEntity.mapperToProduct() =
    Produto(nome = this.nome, preco = this.preco, urlImagem = this.urlImagem)
