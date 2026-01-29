package com.example.examenetiquetas.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.examenetiquetas.R
import com.example.examenetiquetas.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    private var nombre: String? = null
    private var apellido: String? = null
    private var matricula: String? = null
    private var anioMatricula: Int? = null
    private var combustible: String? = null
    private var autonomia: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recuperarDatos()
        initGUI()
        acciones()
    }

    private fun acciones() {
        val imagen = when(combustible){
            "electrico"->{
                binding.imagen.setImageResource(R.drawable.electrico)
            }

            else -> {
                println("Error al recibir datos y mostrar imagen")
            }
        }
    }

    private fun initGUI() {
        binding.nombreRecibido.text = nombre.toString()
        binding.apellidoRecibido.setText(apellido).toString()
        binding.matriculaRecibida.setText(matricula).toString()
        binding.anioRecibido.setText(anioMatricula.toString()).toString()
        binding.tipoGasolinaRecibida.setText(combustible).toString()
    }

    private fun recuperarDatos() {
        nombre = intent.getStringExtra("nombre")
        apellido = intent.getStringExtra("apellido")
        matricula = intent.getStringExtra("matricula")
        anioMatricula = intent.getStringExtra("anioMatricula")?.toInt()
        autonomia = intent.getStringExtra("autonomia")?.toInt()
        combustible = intent.getStringExtra("spinner")
    }
}