package com.cesarwillymc.movie.presentation.authentificacion

import android.os.Bundle
import android.view.View
import com.cesarwillymc.movie.R
import com.cesarwillymc.movie.base.BaseFragment
import com.cesarwillymc.movie.databinding.FragmentAuthBinding


class AuthFragment : BaseFragment<FragmentAuthBinding,  AuthViewModel>(layoutId=R.layout.fragment_auth ) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onInitDependencyInjection() {

    }

    override fun onInitDataBinding() {

    }
}