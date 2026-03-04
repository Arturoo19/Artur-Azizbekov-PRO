package com.example.examenprueba1.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examenprueba1.R
import com.example.examenprueba1.databinding.ItemExamenBinding
import com.example.examenprueba1.model.Examen
import com.example.examenprueba1.ui.fragments.ListadoFragment

class ExamenAdapter(private var context: Context): RecyclerView.Adapter<ExamenAdapter.MyHolder>() {

    private var listaExamenes: ArrayList<Examen>
    private lateinit var listener: OnItemListener


    inner class MyHolder(var binding: ItemExamenBinding): RecyclerView.ViewHolder(binding.root){
        init {
            binding.toolbarCard.inflateMenu(R.menu.menu_listado)
            binding.toolbarCard.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.menu_detalle->{
                        listener.onUserDetailSelected(listaExamenes[bindingAdapterPosition])
                    }
                    R.id.menu_dificultad->{
                        listener.onDificultadSelected(listaExamenes[bindingAdapterPosition])
                    }
                }
                return@setOnMenuItemClickListener true
            }
        }
    }

    init {
        listaExamenes = ArrayList()
        listener = listener as ListadoFragment
    }

    interface OnItemListener{
        fun onUserDetailSelected(examen: Examen)
        fun onDificultadSelected(examen: Examen)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHolder {
        val binding: ItemExamenBinding = ItemExamenBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
        return MyHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MyHolder,
        position: Int
    ) {
        val examen = listaExamenes[position]
        holder.binding.textoTitulo.text = examen.titulo
        holder.binding.textoTema.text = examen.tema
    }

    override fun getItemCount(): Int {
        return listaExamenes.size
    }

    fun clearUsers(): Unit{
        listaExamenes.clear()
        notifyDataSetChanged()
    }
    fun setExamenes(nuevaLista: List<Examen>){
        listaExamenes.clear()
        listaExamenes.addAll(nuevaLista)
        notifyDataSetChanged()
    }

}