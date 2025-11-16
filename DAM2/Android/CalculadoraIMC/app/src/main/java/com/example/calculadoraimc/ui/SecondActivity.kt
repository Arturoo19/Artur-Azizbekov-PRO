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
    private var altura: Double? = null
    private var peso: Double? = null
    private var imc: Double? = null
    private var genero: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SecondActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recuperarDatos()
        mostrarResultado()
        initGUI()
    }

    private fun recuperarDatos() {
        altura = intent.getStringExtra("altura")?.toDouble()
        peso = intent.getStringExtra("peso")?.toDouble()
        genero = intent.getStringExtra(genero)
    }


    private fun initGUI() {
        if (imc == null) {
            println("Error del calculo")
            return
        }
        binding.textResultadoIMC.setText("IMC: %.2f".format(imc))
    }


    private fun mostrarResultado(){


        if (altura == null || peso == null){
            println("Error: datos no recibidos")
            return
        }

        var alturaM = altura!! /100

        imc = peso!!/(alturaM*alturaM)


        mostrarEstadoFisisco(imc)
    }

    private fun mostrarEstadoFisisco(imc: Double?) {
        if (imc!=null){
            if (genero == "masculino"){
                when{
                    imc<18.5->{
                        binding.textEstado.text = "Bajo peso"
                        binding.imageEstado.setImageResource(R.drawable.estado1)
                    }
                    imc in 18.5..24.9->{
                        binding.textEstado.text = "Peso normal"
                        binding.imageEstado.setImageResource(R.drawable.estado2)
                    }
                    imc in 25.0..29.9->{
                        binding.textEstado.text = "Pre-obesidad o Sobrepeso"
                        binding.imageEstado.setImageResource(R.drawable.estado3)
                    }
                    imc in 30.0..34.9->{
                        binding.textEstado.text = "Obesidad clase I"
                        binding.imageEstado.setImageResource(R.drawable.estado4)
                    }
                    imc in 35.0..39.9->{
                        binding.textEstado.text = "Obesidad clase II"
                        binding.imageEstado.setImageResource(R.drawable.estado5)
                    }
                    imc>40->{
                        binding.textEstado.text = "Obesidad clase II"
                        binding.imageEstado.setImageResource(R.drawable.estado6)
                    }
                }
            } else{
                when{
                    imc<16.5->{
                        binding.textEstado.text = "Bajo peso"
                        binding.imageEstado.setImageResource(R.drawable.estado1)
                    }
                    imc in 16.5..22.9->{
                        binding.textEstado.text = "Peso normal"
                        binding.imageEstado.setImageResource(R.drawable.estado2)
                    }
                    imc in 23.0..25.9->{
                        binding.textEstado.text = "Pre-obesidad o Sobrepeso"
                        binding.imageEstado.setImageResource(R.drawable.estado3)
                    }
                    imc in 26.0..30.9->{
                        binding.textEstado.text = "Obesidad clase I"
                        binding.imageEstado.setImageResource(R.drawable.estado4)
                    }
                    imc in 31.0..33.9->{
                        binding.textEstado.text = "Obesidad clase II"
                        binding.imageEstado.setImageResource(R.drawable.estado5)
                    }
                    imc>34->{
                        binding.textEstado.text = "Obesidad clase II"
                        binding.imageEstado.setImageResource(R.drawable.estado6)
                    }
                }
            }

        }

    }


}