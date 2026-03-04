package com.example.arturazizbekove2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.arturazizbekove2.R
import com.example.arturazizbekove2.adapter.AdapterCampanias
import com.example.arturazizbekove2.databinding.FragmentListadoBinding
import com.example.arturazizbekove2.model.Launch
import org.json.JSONObject


class CompaniasFragment : Fragment() {


    private lateinit var binding: FragmentListadoBinding
    private lateinit var adapter: AdapterCampanias

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private val url = "https://api.spacexdata.com/v5/launches"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentListadoBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        adapter = AdapterCampanias(requireContext())
        binding.recyclerLaunch.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerLaunch.adapter = adapter

        realizarPeticion()
    }


    private fun realizarPeticion() {

        val request = JsonArrayRequest(url,
            { response ->

                val lista = ArrayList<Launch>()

                for (i in 0 until response.length()) {

                    val obj: JSONObject = response.getJSONObject(i)

                    val name = obj.getString("name")
                    val detail = obj.optString("details")


                    val image = obj
                        .getJSONObject("links")
                        .getJSONObject("patch")
                        .optString("small")

                    lista.add(Launch(name, detail, image))
                }

                adapter.setLista(lista)

            }, { error ->
                error.printStackTrace()
            })

        Volley.newRequestQueue(requireContext()).add(request)
    }


}