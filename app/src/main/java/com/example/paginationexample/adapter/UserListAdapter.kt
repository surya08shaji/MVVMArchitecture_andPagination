package com.example.paginationexample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.paginationexample.model.UserList
import com.example.paginationexample.databinding.AdapterUserListBinding

class UserListAdapter: PagingDataAdapter<UserList,UserListAdapter.ViewHolder>(UserListComparator){

    class ViewHolder( val view: AdapterUserListBinding):RecyclerView.ViewHolder(view.root)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = getItem(position)!!

        holder.view.nameTxt.text = user.name
        holder.view.locationTxt.text = user.location
        holder.view.stateTxt.text = user.state
        holder.view.countryTxt.text = user.country

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val inflater = LayoutInflater.from(parent.context)
       val binding = AdapterUserListBinding.inflate(inflater,parent,false)
       return ViewHolder(binding)
    }


    object UserListComparator:DiffUtil.ItemCallback<UserList>(){
        override fun areItemsTheSame(oldItem: UserList, newItem: UserList): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: UserList, newItem: UserList): Boolean {
            return oldItem == newItem
        }

    }
}
