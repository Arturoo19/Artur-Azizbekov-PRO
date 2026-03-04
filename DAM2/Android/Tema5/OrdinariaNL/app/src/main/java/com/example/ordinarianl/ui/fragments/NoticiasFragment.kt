package com.example.ordinarianl.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ordinarianl.R
import com.example.ordinarianl.databinding.FragmentNoticiasBinding
import com.example.ordinarianl.model.Post
import com.example.ordinarianl.ui.adapter.PostAdapter
import com.google.firebase.database.FirebaseDatabase

class NoticiasFragment : Fragment(), PostAdapter.OnPostListener {

    private lateinit var binding: FragmentNoticiasBinding
    private lateinit var adapter: PostAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentNoticiasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        adapter = PostAdapter(this)

        binding.recycler.layoutManager =
            LinearLayoutManager(requireContext())

        binding.recycler.adapter = adapter

        FirebaseDatabase.getInstance()
            .reference
            .child("data")
            .child("posts")
            .get()
            .addOnSuccessListener { snapshot ->

                val lista = snapshot.children.mapNotNull {
                    it.getValue(Post::class.java)
                }

                adapter.setLista(lista)
            }
    }

    override fun onVerDetalle(post: Post) {

        val bundle = Bundle()
        bundle.putSerializable("post", post)

        findNavController().navigate(
            R.id.action_noticiasFragment_to_detalleFragment,
            bundle
        )
    }
}