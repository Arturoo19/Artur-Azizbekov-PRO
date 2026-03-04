package com.example.examenprueba1.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.examenprueba1.R
import com.example.examenprueba1.databinding.FragmentImportarBinding
import com.example.examenprueba1.model.Examen
import com.google.firebase.database.FirebaseDatabase
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject


class ImportarFragment : Fragment() {
    private lateinit var binding: FragmentImportarBinding
    private val urlBase = "https://698949d3c04d974bc69ed0b0.mockapi.io/api/v1/examenes"
    private val DB_URL = "https://aazces2526-default-rtdb.europe-west1.firebasedatabase.app/"
    private lateinit var database: FirebaseDatabase


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentImportarBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun realizarPeticionJSON(url: String){
        val database = FirebaseDatabase
            .getInstance(DB_URL)
            .reference
            .child("examenes")
        val peticionJSON: JsonArrayRequest = JsonArrayRequest(
            url,{ response->

                val gson = Gson()
                for (i in 0 until response.length()){
                    val examenJson = response.getJSONObject(i)
                    val examen: Examen = gson.fromJson(
                        examenJson.toString(),
                        Examen::class.java
                    )
                    database.push().setValue(examen)
                }

                findNavController().navigate(R.id.action_importarFragment_to_listadoFragment)

            },{
                error -> error.printStackTrace()
            }
        )
        Volley.newRequestQueue(requireContext()).add(peticionJSON)
    }

    override fun onResume() {
        super.onResume()
        binding.botonImportar.setOnClickListener {
            val database = FirebaseDatabase.getInstance(DB_URL).reference.child("examenes")

            database.get().addOnSuccessListener { snapshot ->
                if (snapshot.exists()) {
                    findNavController().navigate(R.id.action_importarFragment_to_listadoFragment)
                } else {
                    realizarPeticionJSON(urlBase)
                }
            }
        }

    }
}