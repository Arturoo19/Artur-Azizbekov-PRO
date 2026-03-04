package com.example.spacex.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.arturazizbekove2.adapter.AdapterCampanias
import com.example.arturazizbekove2.databinding.FragmentFavoritosBinding
import com.example.arturazizbekove2.model.Launch
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class FavoritosFragment : Fragment() {

    private lateinit var binding: FragmentFavoritosBinding
    private lateinit var adapter: AdapterCampanias

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFavoritosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val user = FirebaseAuth.getInstance().currentUser

        if (user == null) {
            Snackbar.make(binding.root, "No hay sesión iniciada", Snackbar.LENGTH_LONG).show()
            return
        }

        adapter = AdapterCampanias(requireContext())
        binding.recyclerFavoritos.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerFavoritos.adapter = adapter

        FirebaseDatabase.getInstance()
            .reference
            .child("favoritos")
            .child(user.uid)
            .get()
            .addOnSuccessListener {

                val lista = it.children.mapNotNull {
                    it.getValue(Launch::class.java)
                }

                adapter.setLista(lista)
            }
    }
}
