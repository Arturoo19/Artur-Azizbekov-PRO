package com.example.ordinarianl.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ordinarianl.databinding.ItemPostBinding
import com.example.ordinarianl.model.Post

class PostAdapter(
    private val listener: OnPostListener
) : RecyclerView.Adapter<PostAdapter.MyHolder>() {

    private val lista = ArrayList<Post>()

    inner class MyHolder(val binding: ItemPostBinding)
        : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.btnDetalle.setOnClickListener {
                listener.onVerDetalle(lista[bindingAdapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding = ItemPostBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        val post = lista[position]

        holder.binding.textTitle.text = post.title

        holder.binding.textTag.text =
            post.tags?.firstOrNull() ?: "Sin tag"
    }

    override fun getItemCount() = lista.size

    fun setLista(nuevaLista: List<Post>) {
        lista.clear()
        lista.addAll(nuevaLista)
        notifyDataSetChanged()
    }

    interface OnPostListener {
        fun onVerDetalle(post: Post)
    }
}