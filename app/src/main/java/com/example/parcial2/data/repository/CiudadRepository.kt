package com.example.parcial2.data.repository

import com.example.parcial2.data.model.Ciudad

class CiudadRepository {

    private var ciudadGuardada: Ciudad? = null

    fun guardarCiudad(ciudad: Ciudad) {
        ciudadGuardada = ciudad
    }

    fun getCiudadGuardada(): Ciudad? {
        return ciudadGuardada
    }
}
