package com.example.calculadora

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMainBinding
    private var primerNumero: Int? = null
    private var operacionPendiente: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones()

    }

    private fun acciones() {
        val botonesNumeros = listOf(
            binding.btn0,binding.btn1,binding.btn2,binding.btn3,
            binding.btn4,binding.btn5,binding.btn6,binding.btn7,
            binding.btn8,binding.btn9
        )
        for (boton in botonesNumeros){
            boton.setOnClickListener {
                numeroPulsado(boton.text.toString())
            }
        }
        binding.btnReseat.setOnClickListener {
            binding.textIntroducir.text.clear()
            primerNumero = null
            operacionPendiente = null
        }

        val operaciones = listOf(
            binding.btnDividir,binding.btnMultiplicar,binding.btnSumar,
            binding.btnRestar
        )
        for (boton in operaciones){
            boton.setOnClickListener{
                operacionPulsada(boton.text.toString())
            }
        }
        val operacionesCientificos = listOf(
            binding.btnCos,binding.btnSin,binding.btnTan,
            binding.btnSqrt,binding.btnPow
        )
        for (boton in operacionesCientificos){
            boton?.setOnClickListener {
                operacionCientifica(boton.text.toString())
            }
        }
        binding.btnResultado.setOnClickListener{
            calcular()
        }


    }
    private fun operacionCientifica(operacion: String){
        val value = binding.textIntroducir.text.toString().toDoubleOrNull() ?: return

        val resultado = when(operacion){
            "sin"-> Math.sin(Math.toRadians(value))
            "cos" -> Math.cos(Math.toRadians(value))
            "tan" -> Math.tan(Math.toRadians(value))
            "√" , "sqrt" -> Math.sqrt(value)
            "x²", "pow" -> value * value
            else -> return
        }
        binding.textIntroducir.setText(resultado.toString())
    }
    private fun numeroPulsado(numero: String){
        binding.textIntroducir.setText(
            binding.textIntroducir.text.toString() + numero
        )

    }
    private fun operacionPulsada(operacion: String){
        val value = binding.textIntroducir.text.toString().toIntOrNull()
        if (value != null){
            if (primerNumero == null){
                primerNumero = value
            }else if (operacionPendiente != null){
                primerNumero = calculacion(primerNumero!!,value,operacion)
            }
        }
        operacionPendiente = operacion
        binding.textIntroducir.text.clear()
    }
    private fun calcular(){
        val value = binding.textIntroducir.text.toString().toIntOrNull()
        if (value != null && operacionPendiente!= null && primerNumero!= null){
            val resultado = calculacion(primerNumero!!,value,operacionPendiente!!)
            binding.textIntroducir.setText(resultado.toString())
            operacionPendiente = null
            primerNumero = null
        }
    }
    private fun calculacion(num1: Int,num2: Int,operacion: String): Int{
        var resultado = 0
        when(operacion){
            "+"-> resultado = num1+num2
            "-"-> resultado = num1-num2
            "/"-> if (num2 !=0) resultado = num1/num2 else{
                binding.textIntroducir.setText("Error")

            }
            "*"-> resultado = num1*num2
            else -> resultado = num2
        }
        return resultado

    }

    override fun onClick(v: View?) {
        when(v?.id){
            binding.btnResultado.id->{
                calcular()
            }
        }
    }
}