package com.example.consesionario.adapter


import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.consesionario.R
import com.example.consesionario.R.id.itemMarca
import com.example.consesionario.R.id.itemModelo
import com.example.consesionario.databinding.ActivitySecondBinding
import com.example.consesionario.model.Vehiculo

class AdapterModelos(var lista: ArrayList<Vehiculo>, var contexto: Context): BaseAdapter() {
    override fun getCount(): Int {
        return lista.size
    }

    override fun getItem(position: Int): Vehiculo? {
        return lista[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("MissingInflatedId")
    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup?
    ): View? {
        val view: View =
            LayoutInflater.from(contexto).inflate(R.layout.item_spinner,
                parent,false)

        val imageMarca: ImageView = view.findViewById(itemMarca)
        val imageModelo: ImageView = view.findViewById(itemModelo)
        val textoModelo: TextView = view.findViewById(R.id.itemNombre)

        val modelo = lista[position]

        imageMarca.setImageResource(modelo.marca.imagen)
        imageModelo.setImageResource(modelo.imagen)
        textoModelo.setText(modelo.modelo)
        return view
    }
}