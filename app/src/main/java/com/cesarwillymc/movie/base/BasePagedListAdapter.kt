package com.cesarwillymc.movie.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView


abstract class BasePagedListAdapter<T>(
    itemsSame: (T, T) -> Boolean,
    contentsSame: (T, T) -> Boolean
) : PagedListAdapter<T, RecyclerView.ViewHolder>(object : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(old: T, new: T): Boolean = itemsSame(old, new)
    override fun areContentsTheSame(old: T, new: T): Boolean = contentsSame(old, new)
}) {

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    internal var recyclerView: RecyclerView? = null

    init {
        super.setHasStableIds(true)
    }


    abstract fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): RecyclerView.ViewHolder


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        onCreateViewHolder(
            parent = parent,
            inflater = LayoutInflater.from(parent.context),
            viewType = viewType
        )


    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        this.recyclerView = recyclerView
        super.onAttachedToRecyclerView(recyclerView)
    }


    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        this.recyclerView = null
        super.onDetachedFromRecyclerView(recyclerView)
    }


    override fun submitList(pagedList: PagedList<T>?) {
        super.submitList(pagedList)
        if (pagedList.isNullOrEmpty()) {
            recyclerView?.scrollToPosition(0)
        }
    }
}
