package com.cesarwillymc.movie.presentation.listMovies

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.paging.PagedList
import androidx.recyclerview.widget.GridLayoutManager
import com.cesarwillymc.movie.R
import com.cesarwillymc.movie.app.MyApp.Companion.coreComponent
import com.cesarwillymc.movie.base.BaseFragment
import com.cesarwillymc.movie.common.observe
import com.cesarwillymc.movie.core.model.Movie
import com.cesarwillymc.movie.databinding.FragmentListMoviesBinding
import com.cesarwillymc.movie.presentation.listMovies.adapter.ListMovieAdapter
import com.cesarwillymc.movie.presentation.listMovies.adapter.MovieListAdapterState
import com.cesarwillymc.movie.presentation.listMovies.di.DaggerMovieListComponent
import com.cesarwillymc.movie.presentation.listMovies.di.MovieListModule
import javax.inject.Inject


class ListMoviesFragment :
    BaseFragment<FragmentListMoviesBinding, ListMovieViewModel>(layoutId = R.layout.fragment_list_movies) {
    @Inject
    lateinit var viewAdapter: ListMovieAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe(viewModel.state, ::onViewStateChange)
        observe(viewModel.data, ::onViewDataChange)
        observe(viewModel.event, ::onViewEvent)
    }


    override fun onInitDependencyInjection() {
        DaggerMovieListComponent
            .builder()
            .coreComponent(coreComponent(requireContext()))
            .movieListModule(MovieListModule(this))
            .build()
            .inject(this)
    }


    override fun onInitDataBinding() {
        viewBinding.viewModel = viewModel
        viewBinding.includeList.movieList.apply {
            adapter = viewAdapter
            (layoutManager as? GridLayoutManager)?.spanSizeLookup = viewAdapter.getSpanSizeLookup()
            layoutManager = GridLayoutManager(requireActivity(), 2)
        }
    }


    private fun onViewDataChange(viewData: PagedList<Movie>) {
        viewAdapter.submitList(viewData)
    }


    private fun onViewStateChange(viewState: ListMovieViewState) {
        when (viewState) {
            is ListMovieViewState.Loaded ->
                viewAdapter.submitState(MovieListAdapterState.Added)
            is ListMovieViewState.AddLoading ->
                viewAdapter.submitState(MovieListAdapterState.AddLoading)
            is ListMovieViewState.AddError ->
                viewAdapter.submitState(MovieListAdapterState.AddError)
            is ListMovieViewState.NoMoreElements ->
                viewAdapter.submitState(MovieListAdapterState.NoMore)
        }
    }

    private fun onViewEvent(viewEvent: MovieListViewEvent) {
        when (viewEvent) {
            is MovieListViewEvent.OpenMovieDetail -> {
                findNavController().navigate(
                    ListMoviesFragmentDirections.actionListMoviesFragmentToMovieDetailFragment(
                        viewEvent.movie
                    )
                )
            }
        }
    }


}