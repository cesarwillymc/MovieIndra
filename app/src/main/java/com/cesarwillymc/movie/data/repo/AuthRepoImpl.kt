package com.cesarwillymc.movie.data.repo

import com.cesarwillymc.movie.core.model.Usuario

class AuthRepoImpl:AuthRepo {

    override suspend fun signIn(user: String, password: String): Usuario {
        return try{
            requestServer(user, password)
        }catch (e:Exception){
            Usuario(message = "Error desconocido",code = 404,user = null)
        }
    }

    private fun requestServer(user: String, password: String):Usuario{
        val passCorrect="123"
        val userCorrect="Admin"
        if(user != userCorrect ){
            return  Usuario(message = "Usuario incorrecto",code = 401,user = null)
        }
        if(password != passCorrect ){
            return  Usuario(message = "Contraseña incorrecta",code = 401,user = null)
        }
        return Usuario(message = "Se ejecuto correctamente",code = 200,user = "123456789")
    }
}