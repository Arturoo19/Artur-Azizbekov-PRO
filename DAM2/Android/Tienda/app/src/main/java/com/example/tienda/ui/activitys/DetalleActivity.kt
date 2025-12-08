package com.example.tienda.ui.activitys

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tienda.databinding.ActivityDetalleBinding
import com.example.tienda.model.Producto

class DetalleActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetalleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val producto = intent.getSerializableExtra("producto") as Producto

        binding.tvNombre.text = producto.nombre
        binding.tvPrecio.text = producto.precio.toString()
        binding.tvStock.text = producto.stock.toString()
        binding.tvDescripcion.text = producto.descripcion

    }
}