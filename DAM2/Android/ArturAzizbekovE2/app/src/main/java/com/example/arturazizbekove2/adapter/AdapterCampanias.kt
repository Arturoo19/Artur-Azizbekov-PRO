package com.example.arturazizbekove2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.arturazizbekove2.databinding.FragmentListadoBinding
import com.example.arturazizbekove2.databinding.ItemCampaniasBinding
import com.example.arturazizbekove2.model.Launch
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory

class AdapterCampanias(var context: Context): RecyclerView.Adapter<AdapterCampanias.MyHolder>() {
    private lateinit var lista: ArrayList<Launch>
    private val DB_URL = "https://aazces2526-default-rtdb.europe-west1.firebasedatabase.app/"

    private var database = FirebaseDatabase.getInstance(DB_URL)
    private var auth = FirebaseAuth.getInstance()


    init {
        lista = ArrayList()
    }
    inner class MyHolder(var binding: ItemCampaniasBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHolder {
        val binding = ItemCampaniasBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MyHolder,
        position: Int
    ) {
        val launch = lista[position]

        holder.binding.textoName.text = launch.name.toString()
        holder.binding.textoDetail.text = launch.details.toString()

    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun setLista(nuevaLista: List<Launch>) {
        lista.clear()
        lista.addAll(nuevaLista)
        notifyDataSetChanged()
    }


}