package com.example.tienda

import android.app.DialogFragment
import android.app.Fragment
import android.app.FragmentManager
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import android.view.View
import android.widget.AdapterView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tienda.adapter.AdapterProducto
import com.example.tienda.databinding.ActivityMainBinding
import com.example.tienda.dataset.DataSet
import com.example.tienda.model.Producto
import com.example.tienda.ui.dialogs.DialogoInformacion

class MainActivity : AppCompatActivity(),
    AdapterProducto.OnProductoCarritoListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterProducto: AdapterProducto
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val lista: ArrayList<Producto> = DataSet.lista
        // quiero obtener la lista de productos de una categoria determinada
        // categoria

        adapterProducto = AdapterProducto(lista, this)

        if (resources.configuration.orientation == 1) {
            binding.recyclerProductos.layoutManager =
                LinearLayoutManager(
                    this,
                    LinearLayoutManager.VERTICAL, false
                )
        } else {

            binding.recyclerProductos.layoutManager =
                GridLayoutManager(
                    this, 2,
                    GridLayoutManager.VERTICAL, false
                )
        }
        binding.recyclerProductos.adapter = adapterProducto;

        acciones()


    }

    fun acciones() {
        binding.spinnerCategorias.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    var categoriaSeleccionada = parent!!.adapter.getItem(position)
                    var listaFiltrada = DataSet.getListaFiltrada(categoriaSeleccionada.toString())
                    adapterProducto.chageList(listaFiltrada)
                    // adapterProducto = AdapterProducto(listaFiltrada, this@MainActivity)
                    // binding.recyclerProductos.adapter = adapterProducto;
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.menu_carrito -> {
                val intent = Intent(this, CarritoActivity::class.java)
                startActivity(intent)            }

            R.id.menu_filtrar -> {
                filtrarLista()
            }

            R.id.menu_limpiar -> {
                limpiarFiltro()
            }
            R.id.menu_info ->{
                val dialogoInformacion: DialogoInformacion = DialogoInformacion()
                dialogoInformacion.show(supportFragmentManager,null)
            }
        }
        return true
    }

    private fun filtrarLista() {
        val listaFiltrada = DataSet.getListaFiltrada("tecnologia")
        adapterProducto.chageList(listaFiltrada)
    }
    private fun limpiarFiltro() {
        adapterProducto.chageList(DataSet.lista)
        binding.spinnerCategorias.setSelection(0)
    }


    override fun actualizarContadorCarrito() {
        binding.textoContador.text = DataSet.listaCarrito.size.toString()
    }
}