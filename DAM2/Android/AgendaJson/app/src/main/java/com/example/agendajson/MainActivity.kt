package com.example.agendajson

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.agendajson.adapter.AdapterUser
import com.example.agendajson.databinding.ActivityMainBinding
import com.example.agendajson.model.User
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val listaUsers = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.recyclerUsers.layoutManager = LinearLayoutManager(this)

        realizarPeticionJSON()
    }

    private fun realizarPeticionJSON() {
        val url = "https://dummyjson.com/users"

        val request = JsonObjectRequest(
            url,
            { response ->
                val gson = Gson()
                val usersArray = response.getJSONArray("users")

                listaUsers.clear()

                for (i in 0 until usersArray.length()) {
                    val userJSON = usersArray.getJSONObject(i) // ✅ CORREGIDO
                    val user = gson.fromJson(userJSON.toString(), User::class.java)
                    listaUsers.add(user)
                }


                binding.recyclerUsers.adapter = AdapterUser(listaUsers,this)

                Log.v("conexion", "Datos cargados correctamente")
            },
            { error ->
                Log.e("conexion", "Error en la conexión", error)
            }
        )

        Volley.newRequestQueue(this).add(request)
    }
}
