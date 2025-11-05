package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.transition.Visibility
import com.example.loginapp.databinding.ActivityMainBinding
import com.example.loginapp.ui.activity.SecondActivity
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener, AdapterView.OnItemSelectedListener {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        acciones()

    }


    private fun acciones() {
        binding.botonLogin.setOnClickListener(this)
        binding.botonGoogle.setOnClickListener(this)
        binding.botonGit.setOnClickListener(this)
        binding.botonFacebook.setOnClickListener(this)
        binding.checkRecordar.setOnCheckedChangeListener { element,check ->
            binding.botonLogin.isEnabled = check
        }
        binding.spinnerPerfil.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    binding.botonFacebook.visibility = View.INVISIBLE
                    binding.botonGit.visibility = View.INVISIBLE
                    binding.botonGoogle.visibility = View.INVISIBLE
                    when(position){
                        0->{ binding.botonGoogle.visibility = View.VISIBLE }
                        1->{ binding.botonGit.visibility = View.VISIBLE}
                        2->{ binding.botonFacebook.visibility = View.VISIBLE }
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

            }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            binding.botonGoogle.id->{}
            binding.botonFacebook.id->{}
            binding.botonGit.id->{}
            binding.botonLogin.id->{
                binding.botonLogin.setOnClickListener { view ->
                    val correo = binding.editCorreo.text.toString().trim()
                    val contrasena = binding.editPass.text.toString().trim()

                    if (correo.isEmpty() || contrasena.isEmpty()){
                        Snackbar.make(view, "Faltan datos", Snackbar.LENGTH_SHORT).show()
                    } else if (correo.equals("admin@admin.com") && contrasena.equals("admin")){
                        val intent:Intent = Intent(applicationContext,
                            SecondActivity::class.java)

                        

                        intent.putExtra("correo",binding.editCorreo.text.toString())
                        intent.putExtra("pass",binding.editPass.text.toString())
                        intent.putExtra("plataforma",binding.spinnerPerfil.selectedItem.toString())
                        startActivity(intent)
                        finish()
                    } else {
                        Snackbar.make(view,"Los datos son incorrectos", Snackbar.LENGTH_SHORT).show()
                    }
                }


            }

        }
    }

    override fun onItemSelected(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long
    ) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }


}