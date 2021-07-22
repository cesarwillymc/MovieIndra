package com.cesarwillymc.movie.data.repo

import com.cesarwillymc.movie.core.model.Usuario
import com.cesarwillymc.movie.data.utils.RequestUser

class AuthRepoImpl(private val request: RequestUser):AuthRepo {

    override suspend fun signIn(user: String, password: String): Usuario {
        return request.requestServer(user, password)
    }

}