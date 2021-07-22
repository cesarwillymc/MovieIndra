package com.cesarwillymc.movie.presentation.authentificacion

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.fragment.findNavController
import com.cesarwillymc.movie.R
import com.cesarwillymc.movie.app.MyApp
import com.cesarwillymc.movie.base.BaseFragment
import com.cesarwillymc.movie.databinding.FragmentAuthBinding
import com.cesarwillymc.movie.presentation.authentificacion.di.DaggerLoginComponent
import com.cesarwillymc.movie.presentation.authentificacion.di.LoginModule


class AuthFragment : BaseFragment<FragmentAuthBinding, AuthViewModel>(layoutId = R.layout.fragment_auth) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.lblInicioSend.buttonSend.setOnClickListener {
            viewModel.sendMessageLogged()
            signInNumberPhone()
        }
    }

    override fun onInitDependencyInjection() {
        DaggerLoginComponent.builder().coreComponent(MyApp.coreComponent(requireContext()))
            .loginModule(LoginModule(this)).build().inject(this)
    }

    override fun onInitDataBinding() {
        viewBinding.viewModel = viewModel
    }

    private fun signInNumberPhone() {
        if (viewModel.stateLogin.value == null) {
            viewModel.stateLogin.observe(viewLifecycleOwner) {
                when (it) {
                    AuthViewState.Loading -> {
                        hideKeyboard()
                    }
                    AuthViewState.Complete -> {
                        try {
                            findNavController().navigate(
                                AuthFragmentDirections.actionAuthFragmentToListMoviesFragment()
                            )
                        } catch (e: Exception) {
                            Log.e("errornavi", "$e")
                        }

                    }
                    AuthViewState.Error -> {
                        toast(viewModel.messageError)
                    }
                    else -> {
                    }
                }
            }
        }


    }
}