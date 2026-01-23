package com.example.agendajson.dialogs


import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.core.graphics.createBitmap
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.example.agendajson.R
import com.example.agendajson.model.User
import org.w3c.dom.Text

class DialogoUser: DialogFragment() {
    private lateinit var user: User

    companion object{
        fun newInstance(user: User): DialogoUser{
            val dialog = DialogoUser()
            val bundle = Bundle()
            bundle.putSerializable("user",user)
            dialog.arguments = bundle
            return dialog
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.user = this.arguments?.getSerializable("user") as User
        /*val bundle = arguments
        user =  bundle?.getSerializable("user") as User*/
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        val view = layoutInflater.inflate(
            com.example.agendajson.R.layout.dialog_user,
            null)

        val imagen = view.findViewById<ImageView>(R.id.imagenCard)
        val textApellido = view.findViewById<TextView>(R.id.textApellido)
        val textEmail  = view.findViewById<TextView>(R.id.textEmail)
        val textEdad = view.findViewById<TextView>(R.id.textEdad)
        val textGenero = view.findViewById<TextView>(R.id.textGenero)
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar2)




        toolbar.title = "${user.firstName} ${user.lastName}"
        textApellido.text = user.lastName
        textEmail.text = user.email
        textEdad.text = "Edad: ${user.age}"
        textGenero.text = "Género: ${user.gender}"

        Glide.with(requireContext())
            .load(user.image)
            .circleCrop()
            .into(imagen)

        builder.setView(view)
        builder.setTitle("Usuario Seleccionado")
        builder.setPositiveButton("OK",{_,_-> dismiss() })
        return builder.create()
    }
}