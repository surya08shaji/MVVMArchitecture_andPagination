package com.example.paginationexample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.paginationexample.databinding.ListItemProgressbarBinding

class PagingLoadStateAdapter :
    LoadStateAdapter<PagingLoadStateAdapter.PagingLoadStateViewHolder>() {
    class PagingLoadStateViewHolder(view: ListItemProgressbarBinding) :
        RecyclerView.ViewHolder(view.root)

    override fun onBindViewHolder(holder: PagingLoadStateViewHolder, loadState: LoadState) {
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): PagingLoadStateViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemProgressbarBinding.inflate(inflater, parent, false)
        return PagingLoadStateViewHolder(binding)
    }

}