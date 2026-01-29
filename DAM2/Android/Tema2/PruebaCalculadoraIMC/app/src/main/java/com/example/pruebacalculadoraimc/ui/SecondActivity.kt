package com.example.pruebacalculadoraimc.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pruebacalculadoraimc.R
import com.example.pruebacalculadoraimc.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding

    private var altura: Double? = null
    private var peso: Double? = null
    private var genero: String? = null
    private var imc: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recuperarDatos()
    }

    private fun recuperarDatos() {
        altura = intent.getStringExtra("altura")?.toDouble()
        peso = intent.getStringExtra("peso")?.toDouble()
        genero = intent.getStringExtra("genero")
    }
}