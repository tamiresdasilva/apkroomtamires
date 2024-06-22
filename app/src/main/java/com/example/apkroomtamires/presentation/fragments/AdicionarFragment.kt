package com.example.apkroomtamires.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.apkroomtamires.R
import com.example.apkroomtamires.data.Produto
import com.example.apkroomtamires.databinding.FragmentAdicionarBinding
import com.example.apkroomtamires.presentation.viewmodels.ProductViewmodel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdicionarFragment : Fragment() {
    private lateinit var binding: FragmentAdicionarBinding
    private lateinit var productViewModel: ProductViewmodel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAdicionarBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productViewModel = ViewModelProvider(this)[ProductViewmodel::class.java]

        binding.btnSalvar.setOnClickListener {
            val produto = Produto(
                nome = binding.colocarNome.text.toString(),
                preco = binding.colocarPreco.text.toString(),
                urlImagem = binding.colocarUrlProduto.text.toString()
            )

            productViewModel.adicionarProduto(produto)

            findNavController().navigate(R.id.action_adicionarFragment_to_homeFragment)
        }
    }

}