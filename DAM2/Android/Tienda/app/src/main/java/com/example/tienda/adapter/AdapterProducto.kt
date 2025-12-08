package com.example.tienda.adapter

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tienda.R
import com.example.tienda.databinding.ItemProductoBinding
import com.example.tienda.dataset.DataSet
import com.example.tienda.model.Producto
import com.example.tienda.ui.activitys.DetalleActivity

class AdapterProducto(var lista: ArrayList<Producto>, var contexto: Context) :
    RecyclerView.Adapter<AdapterProducto.MyHolder>() {

    private var listener: OnProductoCarritoListener = contexto as OnProductoCarritoListener

    inner class MyHolder(var binding: ItemProductoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding = ItemProductoBinding.inflate(LayoutInflater.from(contexto), parent, false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        val producto = lista[position]

        Glide.with(contexto)
            .load(producto.imagen)
            .placeholder(R.drawable.producto)
            .into(holder.binding.imagenFila)

        holder.binding.nombreFila.text = producto.nombre

        // BOTÓN DETALLES

        holder.binding.btnDetalle.setOnClickListener {
            val intent = Intent(contexto, DetalleActivity::class.java)
            intent.putExtra("producto", producto)
            contexto.startActivity(intent)
        }

        
        holder.binding.btnCompra.setOnClickListener {
            mostrarDialogoConfirmacion(producto)
        }
    }

    override fun getItemCount(): Int = lista.size

    fun chageList(nuevaLista: ArrayList<Producto>) {
        lista = nuevaLista
        notifyDataSetChanged()
    }


    //  FUNCIÓN: MOSTRAR DIÁLOGО DE CONFIRMACIÓN

    private fun mostrarDialogoConfirmacion(producto: Producto) {
        val builder = AlertDialog.Builder(contexto)
        builder.setTitle("Confirmación")
        builder.setMessage("¿Estás seguro de que quieres añadir '${producto.nombre}' al carrito?")

        builder.setPositiveButton("Sí") { _, _ ->
            DataSet.addProducto(producto)
            listener.actualizarContadorCarrito()
        }

        builder.setNegativeButton("No") { dialog, _ ->
            dialog.dismiss()
        }

        builder.create().show()
    }

    interface OnProductoCarritoListener {
        fun actualizarContadorCarrito()
    }
}
