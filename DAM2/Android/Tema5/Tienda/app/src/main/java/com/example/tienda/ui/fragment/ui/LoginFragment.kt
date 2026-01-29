package com.example.tienda.ui.fragment.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tienda.R
import com.example.tienda.data.DataSet
import com.example.tienda.databinding.FragmentLoginBinding


class LoginFragment: Fragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }



    override fun onResume() {
        super.onResume()
        binding.btnLogin.setOnClickListener {
            if (DataSet.loginUser()){
                findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
            }
        }
        binding.btnRegistro.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registroFragment2)
        }
    }
}