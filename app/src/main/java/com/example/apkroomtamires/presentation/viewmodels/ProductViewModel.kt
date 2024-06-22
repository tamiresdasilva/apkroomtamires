package com.example.apkroomtamires.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apkroomtamires.commons.utils.Resultado
import com.example.apkroomtamires.data.Produto
import com.example.apkroomtamires.data.repositories.ProdutoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewmodel @Inject constructor(private val productRepository: ProdutoRepository) :
    ViewModel() {

    private val _produtos = MutableLiveData<Resultado<List<Produto>>>()
    val produtos = _produtos

    fun fetchProducts() {
        _produtos.postValue(Resultado.Loading)

        viewModelScope.launch(Dispatchers.IO) {
            delay(3000)

            try {
                val result = productRepository.fetchAllProducts()
                _produtos.postValue(Resultado.Success(data = result))
            } catch (e: Exception) {
                _produtos.postValue(Resultado.Error(e))
            }
        }
    }

    fun adicionarProduto(produto: Produto) = viewModelScope.launch(Dispatchers.IO) {
        productRepository.adicionarProduto(produto)
    }

    fun deletarProduto(produto: Produto) = viewModelScope.launch(Dispatchers.IO) {
        productRepository.removeProduto(produto)
        fetchProducts()
    }
}