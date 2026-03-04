package com.example.arturazizbekove2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.arturazizbekove2.R
import com.example.arturazizbekove2.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth


class LoginFragment : Fragment() {
    private var auth = FirebaseAuth.getInstance()
    private lateinit var binding: FragmentLoginBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater,container,false)
        return binding.root
    }



    override fun onResume() {
        super.onResume()
        binding.botonIniciar.setOnClickListener {
            val textLogin = binding.editTextLogin.text.toString()
            val textPass = binding.editTextPass.text.toString()
            auth.signInWithEmailAndPassword(textLogin, textPass)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        findNavController().navigate(R.id.action_loginFragment_to_companiasFragment)
                    } else {
                        auth.createUserWithEmailAndPassword(textLogin, textPass)
                            .addOnCompleteListener {
                                Snackbar.make(binding.root, "Usuario creado", Snackbar.LENGTH_LONG)
                                    .setAction("Iniciar sesión") {
                                        findNavController().navigate(R.id.action_loginFragment_to_companiasFragment)
                                    }.show()
                            }
                    }
                }
        }
    }
}