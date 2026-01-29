package com.example.tienda.data

import com.example.tienda.model.Usuario

class DataSet {
    companion object{
        val listaUsuario: ArrayList<Usuario> = ArrayList()
        fun registrarUser(usuario: Usuario): Boolean{
            if (listaUsuario.filter { it.correo == usuario.correo }!=null){
                return false
            } else{
                this.listaUsuario.add(usuario)
                return true
            }

        }
        fun loginUser(correo: String,pass: String): Boolean{


            return listaUsuario.find { it.correo == correo && it.password == pass }!= null
        }
    }
}