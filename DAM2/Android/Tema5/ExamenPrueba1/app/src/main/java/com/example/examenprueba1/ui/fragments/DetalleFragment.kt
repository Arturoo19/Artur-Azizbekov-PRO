package com.example.examenprueba1.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.examenprueba1.R
import com.example.examenprueba1.databinding.FragmentDetalleBinding
import com.example.examenprueba1.model.Examen
import com.google.firebase.Firebase
import com.google.firebase.database.FirebaseDatabase


class DetalleFragment : Fragment() {
    private lateinit var examen: Examen


    private lateinit var binding: FragmentDetalleBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        examen = arguments?.getSerializable("examen") as Examen
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetalleBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textTitulo.text = examen.titulo
        binding.textTema.text = examen.tema
    }





}