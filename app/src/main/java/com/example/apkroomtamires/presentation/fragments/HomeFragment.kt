package com.example.apkroomtamires.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.apkroomtamires.R
import com.example.apkroomtamires.commons.utils.Resultado
import com.example.apkroomtamires.data.Produto
import com.example.apkroomtamires.databinding.FragmentHomeBinding
import com.example.apkroomtamires.presentation.adapters.ProductAdapter
import com.example.apkroomtamires.presentation.viewmodels.ProductViewmodel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var productViewModel: ProductViewmodel
    private lateinit var adapter: ProductAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productViewModel = ViewModelProvider(this)[ProductViewmodel::class.java]

        createAdapter()
        observers()
        productViewModel.fetchProducts()
    }

    private fun createAdapter() {
        adapter = ProductAdapter(
            goToDetails = ::goToDetail,
            removeItem = ::removeItem
        )

        binding.recyclerViewProduto.adapter = adapter
    }

    private fun observers() {
        productViewModel.produtos.observe(viewLifecycleOwner) { resultado ->
            when(resultado) {
                is Resultado.Loading -> {
                    binding.barraDeProgresso.visibility = View.VISIBLE
                    binding.recyclerViewProduto.visibility = View.GONE
                }

                is Resultado.Success -> {
                    binding.barraDeProgresso.visibility = View.GONE
                    binding.recyclerViewProduto.visibility = View.VISIBLE
                    adapter.setUpList(resultado.data)
                }

                is Resultado.Error -> {
                    binding.barraDeProgresso.visibility = View.GONE
                    binding.recyclerViewProduto.visibility = View.GONE
                    Log.i("Erro", "erro")
                }
            }
        }
    }
    private fun removeItem(produto: Produto) {
        productViewModel.deletarProduto(produto)
    }
    private fun goToDetail(produto: Produto) {
        Log.i("produto", produto.toString())
        val bundle = bundleOf("data" to produto)
        findNavController().navigate(R.id.action_homeFragment_to_sobreProdutoActivity, bundle)
    }
}