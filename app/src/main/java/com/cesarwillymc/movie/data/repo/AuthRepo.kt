package com.cesarwillymc.movie.data.repo

import com.cesarwillymc.movie.core.model.Usuario

interface AuthRepo {
    suspend fun signIn(user:String,password:String): Usuario
}