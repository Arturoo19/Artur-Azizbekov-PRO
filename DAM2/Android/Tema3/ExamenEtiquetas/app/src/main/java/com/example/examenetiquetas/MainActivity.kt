package com.example.examenetiquetas

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterViewFlipper
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.examenetiquetas.databinding.ActivityMainBinding
import com.example.examenetiquetas.ui.SecondActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias()
        acciones()
    }

    private fun instancias() {
        val combustibles = arrayOf("gasolina", "diesel", "electrico", "hibrido")

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            combustibles
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinnerConmustible.adapter = adapter


        binding.spinnerConmustible.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                val seleccionado = combustibles[position]

                when (seleccionado) {

                    "electrico", "hibrido" -> {
                        binding.editTextYear.setText("2018")
                        binding.editTextYear.isEnabled = false
                    }

                    else -> {
                        binding.editTextYear.isEnabled = true
                    }
                }

                if (seleccionado == "hibrido") {
                    binding.editTextAutonomia.isEnabled = true
                } else {
                    binding.editTextAutonomia.isEnabled = false
                    binding.editTextAutonomia.setText("")
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun acciones() {
        binding.botonCambiarPantalla.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {

            binding.botonCambiarPantalla.id -> {

                val nombrePropietario = binding.nombrePropietario.text.toString().trim()
                val apellidoPropietario = binding.apellidoPropietario.text.toString().trim()
                val matricula = binding.editTextMatricula.text.toString().trim()
                val anioMatricula = binding.editTextYear.text.toString().trim()
                val autonomia = binding.editTextAutonomia.text.toString().trim()
                var seleccionadoSpinner = binding.spinnerConmustible.onItemSelectedListener

                seleccionadoSpinner = object : AdapterView.OnItemSelectedListener{
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        val intent: Intent = Intent(applicationContext, SecondActivity::class.java)
                        intent.putExtra("spinner",seleccionadoSpinner.toString())
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        Snackbar.make(v,"Tienes que seleccionar conmustible", Snackbar.LENGTH_SHORT).show()
                    }


                }
                if (!nombrePropietario.isEmpty() && !apellidoPropietario.isEmpty()
                    && !matricula.isEmpty() && !anioMatricula.isEmpty()){
                    val intent: Intent = Intent(this, SecondActivity::class.java)
                    intent.putExtra("nombre",nombrePropietario)
                    intent.putExtra("apellido",apellidoPropietario)
                    intent.putExtra("matricula",matricula)
                    intent.putExtra("anioMatricula",anioMatricula)
                    if (!autonomia.isEmpty()){
                        intent.putExtra("autonomia",autonomia)
                    }
                    startActivity(intent)

                } else{
                    Snackbar.make(v,"Rellena todos los campos", Snackbar.LENGTH_SHORT).show()
                }



            }
        }
    }
}
