package com.example.tienda.ui.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.tienda.MainActivity
import com.google.android.material.snackbar.Snackbar


class DialogoComparar: DialogFragment() {
    private lateinit var listener: OnCompararListener
    private var opcionSeleccionada: String? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnCompararListener
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        val opciones: Array<CharSequence> = arrayOf("precio","categoria","stock")

        builder.setTitle("Comparar productos")
        builder.setSingleChoiceItems(opciones,-1){view,position->
            if (opcionSeleccionada!= null){
             listener.OnCompararSelected(opcionSeleccionada!!)
            }

            dismiss()
        }
        builder.setPositiveButton("Seleccionar") { _, _ ->
            opcionSeleccionada?.let {
                listener.OnCompararSelected(it)
            }
        }


        return builder.create()
    }
    interface OnCompararListener{
        fun OnCompararSelected(opcion: String)
    }
}