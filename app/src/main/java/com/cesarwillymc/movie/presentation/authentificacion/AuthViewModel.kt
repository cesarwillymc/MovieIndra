package com.cesarwillymc.movie.presentation.authentificacion


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.cesarwillymc.movie.base.BaseViewModel
import com.cesarwillymc.movie.data.repo.AuthRepo
import kotlinx.coroutines.launch

class AuthViewModel(private val repo: AuthRepo) : BaseViewModel() {

    private val _stateUser = MutableLiveData<AuthViewState>()
    val stateUser: LiveData<AuthViewState> get() = _stateUser


    private lateinit var _dataUser: String
    val dataUser get() = _dataUser
    fun updateTextUser(User: CharSequence) {
        if (User.isNotEmpty()) {
            if (User.length > 3) {
                _stateUser.postValue(AuthViewState.UserSucces)
                _dataUser = User.toString()
            } else {
                _stateUser.postValue(AuthViewState.UserError)
            }
        } else {
            _stateUser.postValue(AuthViewState.UserEmpty)
        }
    }


    private val _statePass = MutableLiveData<AuthViewState>()
    val statePass: LiveData<AuthViewState> get() = _statePass

    private lateinit var _dataPass: String
    val dataPass get() = _dataPass
    fun updateTextPassUser(Pass: CharSequence) {
        if (Pass.isNotEmpty()) {
            if (Pass.length > 2) {
                _statePass.postValue(AuthViewState.PassSucces)
                _dataPass = Pass.toString()
            } else {
                _statePass.postValue(AuthViewState.PassError)
            }
        } else {
            _statePass.postValue(AuthViewState.PassEmpty)
        }
    }

    private val _stateLogin = MutableLiveData<AuthViewState>()
    val stateLogin: LiveData<AuthViewState> get() = _stateLogin
    var messageError=""
    fun sendMessageLogged() {
        viewModelScope.launch {
            _stateLogin.postValue(AuthViewState.Loading)
            try {
                val response = repo.signIn(dataUser, dataPass)
                if(response.code==200){
                    _stateLogin.postValue(AuthViewState.Complete)
                }else{
                    messageError= response.message
                    _stateLogin.postValue(AuthViewState.Error)
                }
            } catch (e: Exception) {
                messageError= e.message?:"Error desconocido"
                _stateLogin.postValue(AuthViewState.Error)
            }
        }
    }

    fun onStopViewModel() {
        _stateLogin.postValue(null)
    }
}