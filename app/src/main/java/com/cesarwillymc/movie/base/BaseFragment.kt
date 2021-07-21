package com.cesarwillymc.movie.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.Fragment

abstract class BaseFragment<ViewModel  : BaseViewModel, DB : ViewDataBinding>(@LayoutRes val layout: Int) : Fragment() {

    protected abstract val viewModel: ViewModel
    open lateinit var binding: DB

    private fun onCreateConfig(inflater: LayoutInflater, container: ViewGroup) {
        binding = DataBindingUtil.inflate(inflater, layout, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.setVariable(BR.viewModel, viewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        onCreateConfig(inflater, container!!)
        super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }


}
