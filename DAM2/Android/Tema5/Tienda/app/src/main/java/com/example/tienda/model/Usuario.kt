package com.example.tienda.model

import java.io.Serializable


data class Usuario(
    var nombre: String?= null,
    var apellido: String?= null,
    var edad: Int?= null,
    var correo: String?= null,
    var password: String? = null): Serializable
