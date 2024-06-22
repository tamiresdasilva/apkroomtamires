package com.example.apkroomtamires

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.apkroomtamires.data.Produto
import com.example.apkroomtamires.databinding.ActivitySobreProdutoBinding
import dagger.hilt.android.AndroidEntryPoint

@Suppress("DEPRECATION")
@AndroidEntryPoint
class SobreProdutoActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySobreProdutoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySobreProdutoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        configurarBarraDeFerramentas("Detalhe do produto", true)

        val productBundle = if (Build.VERSION.SDK_INT >= 33) {
            intent?.getSerializableExtra("data", Produto::class.java)
        } else {
            intent?.getSerializableExtra("data") as? Produto
        }

        productBundle?.let { product ->
            binding.produto = product
        }
    }
}