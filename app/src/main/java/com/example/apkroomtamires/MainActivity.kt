package com.example.apkroomtamires

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import com.example.apkroomtamires.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var configuracaoBarraSuperior: AppBarConfiguration
    private lateinit var controladorNavegacao: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbar
        val menuInferior = binding.bottomMenu


        controladorNavegacao = Navigation.findNavController(this, R.id.meu_nav_host_fragment)
        configuracaoBarraSuperior = AppBarConfiguration(navGraph = controladorNavegacao.graph)


        setSupportActionBar(toolbar)
        NavigationUI.setupWithNavController(menuInferior, controladorNavegacao)
        NavigationUI.setupActionBarWithNavController(this, controladorNavegacao, configuracaoBarraSuperior)
    }

    override fun onSupportNavigateUp(): Boolean {
    return findNavController(R.id.meu_nav_host_fragment).navigateUp(configuracaoBarraSuperior)
     }
}