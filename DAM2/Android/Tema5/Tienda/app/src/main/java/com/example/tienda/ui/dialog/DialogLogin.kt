package com.example.tienda.ui.dialog


import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.tienda.R
import com.example.tienda.databinding.FragmentLoginBinding

class DialogLogin: DialogFragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())

        builder.setTitle("Registro correcto")
        builder.setMessage("Quieres iniciar seciom con el usuario?")
        builder.setPositiveButton("SI",{_,_->{
            findNavController().navigate(R.id.action_dialogLogin_to_mainFragment)
        }})
        builder.setNegativeButton("NO",{_,_->{
            findNavController().navigate(R.id.action_dialogLogin_to_loginFragment)
        }})
        builder.setView(binding.root)


        return builder.create()
    }
}