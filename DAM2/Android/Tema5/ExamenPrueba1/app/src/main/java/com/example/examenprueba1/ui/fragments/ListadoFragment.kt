package com.example.examenprueba1.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.examenprueba1.R
import com.example.examenprueba1.databinding.FragmentListadoBinding
import com.example.examenprueba1.model.Examen
import com.example.examenprueba1.ui.adapter.ExamenAdapter
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.FirebaseDatabase

class ListadoFragment : Fragment(), ExamenAdapter.OnItemListener {

    private lateinit var binding: FragmentListadoBinding
    private lateinit var adapter: ExamenAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        adapter  = ExamenAdapter(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListadoBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerExamenes.layoutManager =
            androidx.recyclerview.widget.LinearLayoutManager(requireContext())
        binding.recyclerExamenes.adapter = adapter

        FirebaseDatabase.getInstance()
            .reference
            .child("examenes")
            .get().addOnSuccessListener {
                snapshot ->
                val lista = snapshot.children.mapNotNull {
                    it.getValue(Examen::class.java)
                }
                adapter.setExamenes(lista)
            }
    }

    override fun onUserDetailSelected(examen: Examen) {
        val bundle = Bundle()
        bundle.putSerializable("examen",examen)
        findNavController().navigate(R.id.action_listadoFragment_to_detalleFragment,bundle)
    }

    override fun onDificultadSelected(examen: Examen) {
        Snackbar.make(binding.root,
            "Dificultad: ${examen.dificultad}",
            Snackbar.LENGTH_LONG).show()
    }


}