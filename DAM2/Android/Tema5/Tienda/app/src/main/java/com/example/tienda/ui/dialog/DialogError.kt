package com.example.tienda.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.tienda.databinding.FragmentLoginBinding

class DialogError: DialogFragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())

        builder.setTitle("Error")
        builder.setMessage("Error en el registro")
        builder.setView(binding.root)

        return builder.create()
    }
}