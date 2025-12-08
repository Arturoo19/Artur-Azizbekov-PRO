package com.example.tienda.ui.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment

class DialogoInformacion : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())

        builder.setTitle("Informacion de la APP")
        builder.setPositiveButton("OK",{_,_->{
            Log.v("dialogo","Pulsado alboton positivo")
        }})
        builder.setNegativeButton("No") { dialog, _ ->
            dialog.dismiss()
        }


        return builder.create()
    }


}