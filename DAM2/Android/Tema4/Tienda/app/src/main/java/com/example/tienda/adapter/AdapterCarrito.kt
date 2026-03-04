package com.example.tienda.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tienda.R
import com.example.tienda.databinding.ActivityCarritoBinding
import com.example.tienda.databinding.ItemCariitoBinding
import com.example.tienda.dataset.DataSet
import com.example.tienda.model.Producto

class AdapterCarrito(var lista: ArrayList<Producto>, var contexto: Context)
    : RecyclerView.Adapter<AdapterCarrito.MyHolder>() {


    private var listener: AdapterProducto.OnProductoCarritoListener = contexto as AdapterProducto.OnProductoCarritoListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding = ItemCariitoBinding.inflate(LayoutInflater.from(contexto),parent,false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val producto = lista[position]

        Glide.with(contexto)
            .load(producto.imagen)
            .placeholder(R.drawable.producto)
            .into(holder.binding.imagenFila)

        holder.binding.nombreFila.text = producto.nombre

        holder.binding.btnEliminar.setOnClickListener {
            lista.remove(producto)
            DataSet.listaCarrito.remove(producto)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,lista.size)

            listener.actualizarContadorCarrito()
        }
    }


    override fun getItemCount(): Int = lista.size

    inner class MyHolder(var binding: ItemCariitoBinding): RecyclerView.ViewHolder(binding.root)


}