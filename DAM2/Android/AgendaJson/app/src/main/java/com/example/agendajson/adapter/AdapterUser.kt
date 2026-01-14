package com.example.agendajson.adapter

import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.agendajson.databinding.ActivityMainBinding
import com.example.agendajson.databinding.ItemUserBinding
import com.example.agendajson.model.User

class AdapterUser(var lista: List<User>,
    var contexto: Context):
    RecyclerView.Adapter<AdapterUser.MyHolder>(){
    inner class MyHolder(var binding: ItemUserBinding):
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(contexto),
            parent,false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MyHolder,
        position: Int
    ) {
        val user = lista[position]
        holder.binding.txtName.text = "${user.firstName} ${user.lastName}"
        holder.binding.txtEmail.text = user.email

        Glide.with(contexto).load(user.image)
            .placeholder(R.drawable.ic_menu_view)
            .into(holder.binding.imgUser)

    }

    override fun getItemCount(): Int {
        return lista.size
    }
    fun chageLista(nuevaLista: ArrayList<User>){
        this.lista = nuevaLista
        notifyDataSetChanged()
    }

}