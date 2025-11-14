package com.example.calculadoraimc.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadoraimc.R
import com.example.calculadoraimc.databinding.SecondActivityBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: SecondActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SecondActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun calcularIMC(altura: Int,peso: Int): Double{
        val imc = (peso/(altura*altura)).toDouble()
        return imc
    }
    
}