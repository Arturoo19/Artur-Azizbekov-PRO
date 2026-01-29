package com.example.tienda.ui.fragment.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tienda.databinding.FragmentLoginBinding
import com.example.tienda.databinding.FragmentRegistroBinding


class RegistroFragment: Fragment() {
    private lateinit var binding: FragmentRegistroBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistroBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        binding.btnRegistro.setOnClickListener {
            val correo = binding.editCorreoRegistro.text.toString()
            val password = binding.editPassRegistro.text.toString()

        }
    }
}