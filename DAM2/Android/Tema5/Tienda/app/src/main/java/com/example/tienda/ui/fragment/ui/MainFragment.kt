package com.example.tienda.ui.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tienda.databinding.FragmentMainBinding
import com.example.tienda.databinding.FragmentRegistroBinding
import com.example.tienda.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private val DB_URL =
        "https://aazces2526-default-rtdb.europe-west1.firebasedatabase.app/"

    private lateinit var uid: String

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
        uid = auth.currentUser!!.uid
        database =
            FirebaseDatabase.getInstance(DB_URL)
        database.reference.child("usuarioLogeado").setValue(auth.currentUser!!.uid)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()


        database.reference.child("usuarios")
            .child(uid)
            .child("nombre")
            .addListenerForSingleValueEvent(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    val nombre = snapshot.getValue(String::class.java)
                    binding.textNombreMain.text = "Bienvenido ${nombre}"
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.v("Firebase",error.message)
                }
            })
        database.reference.child("usuarios")
            .child(uid)
            .child("preferencias")
            .addChildEventListener(object : ChildEventListener{
                override fun onChildAdded(
                    snapshot: DataSnapshot,
                    previousChildName: String?
                ) {
                    val preferencias = snapshot.getValue(String::class.java)
                    binding.textPreferencias.append("$preferencias, ")
                }

                override fun onChildChanged(
                    snapshot: DataSnapshot,
                    previousChildName: String?
                ) {
                }

                override fun onChildRemoved(snapshot: DataSnapshot) {
                }

                override fun onChildMoved(
                    snapshot: DataSnapshot,
                    previousChildName: String?
                ) {
                }

                override fun onCancelled(error: DatabaseError) {
                }

            })





        //binding.textNombreMain.text = uid
        binding.guardarDatos.setOnClickListener {

        }

        binding.elimiarDatos.setOnClickListener {
            database.reference.child("usuarios").child(uid).setValue(null)
        }
    }


}