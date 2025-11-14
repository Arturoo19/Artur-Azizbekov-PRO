package com.example.calculadoraimc

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadoraimc.databinding.ActivityMainBinding
import com.example.calculadoraimc.ui.SecondActivity
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

                if (altura.isEmpty() || peso.isEmpty()){
                    Snackbar.make(v,"Faltan datos",Snackbar.LENGTH_SHORT).show()
                } else{
                    val intent: Intent = Intent(
                        this, SecondActivity::class.java)

                    intent.putExtra("altura",altura)
                    intent.putExtra("peso",peso)
                    startActivity(intent)
                    //finish()

                }
            }

        }
    }
}