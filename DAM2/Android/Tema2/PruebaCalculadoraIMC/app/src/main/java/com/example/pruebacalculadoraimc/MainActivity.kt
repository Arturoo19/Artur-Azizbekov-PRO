package com.example.pruebacalculadoraimc

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pruebacalculadoraimc.databinding.ActivityMainBinding
import com.example.pruebacalculadoraimc.ui.SecondActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        acciones()
    }

    private fun acciones() {
        binding.botonCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            binding.botonCalcular.id->{
                val altura = binding.textAltura.text.toString().trim()
                val peso = binding.textPeso.text.toString().trim()
                val selectedId = binding.radioGroupGenero.checkedRadioButtonId

                if (altura.isEmpty()|| peso.isEmpty() || selectedId ==-1){
                    Snackbar.make(v,"Faltan datos por rellenar", Snackbar.LENGTH_SHORT).show()
                    return

                } else{
                    val intent: Intent = Intent(
                        this, SecondActivity::class.java)
                    val genero = if (selectedId == binding.radioButtonMasculino.id){
                        "masculino"
                    } else{
                        "femenino"
                    }
                    intent.putExtra("altura",altura)
                    intent.putExtra("peso",peso)
                    intent.putExtra("genero",genero)
                }

            }
        }
    }

}