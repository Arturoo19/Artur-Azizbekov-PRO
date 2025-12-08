package com.example.tienda

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tienda.adapter.AdapterProducto
import com.example.tienda.databinding.ActivityCarritoBinding
import com.example.tienda.dataset.DataSet

class CarritoActivity : AppCompatActivity(), AdapterProducto.OnProductoCarritoListener {

    private lateinit var recyclerCarrito: RecyclerView
    private lateinit var binding: ActivityCarritoBinding
    private lateinit var adapterCarrito: AdapterProducto

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarritoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerCarrito = findViewById(R.id.recyclerCarrito)
        recyclerCarrito.layoutManager = LinearLayoutManager(this)

        // Adapter reutilizado, usando la listaCarrito
        adapterCarrito = AdapterProducto(DataSet.listaCarrito, this)
        recyclerCarrito.adapter = adapterCarrito
    }

    override fun actualizarContadorCarrito() {
    }

}
