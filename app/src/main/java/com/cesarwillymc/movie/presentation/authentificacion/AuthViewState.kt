package com.cesarwillymc.movie.presentation.authentificacion

import com.cesarwillymc.movie.base.BaseViewState


sealed class AuthViewState : BaseViewState {

    /** Edit Text State send info login**/
    object Loading : AuthViewState()

    object Complete : AuthViewState()

    object Error : AuthViewState()


    fun isLoading() = this is Loading

    fun isComplete() = this is Complete

    fun isError() = this is Error


    /** Edit Text State User **/
    object UserEmpty : AuthViewState()
    object UserError : AuthViewState()
    object UserSucces : AuthViewState()

    fun isUserEmpty() = this is UserEmpty
    fun isUserError() = this is UserError
    fun isUserSucces() = this is UserSucces

    /** Edit Text State Password**/
    object PassEmpty : AuthViewState()
    object PassError : AuthViewState()
    object PassSucces : AuthViewState()

    fun isPassEmpty() = this is PassEmpty

    fun isPassError() = this is PassError

    fun isPassSucces() = this is PassSucces

}
