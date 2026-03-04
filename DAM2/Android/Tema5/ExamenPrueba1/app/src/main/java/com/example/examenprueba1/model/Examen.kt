package com.example.examenprueba1.model

import android.R
import java.io.Serializable

data class Examen(
    var id: String? = null,
    var titulo: String? = null,
    var tema: String? = null,
    var dificultad: String? = null,
    var detalle: String? = null
): Serializable