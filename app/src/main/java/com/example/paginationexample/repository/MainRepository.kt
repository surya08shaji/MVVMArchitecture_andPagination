package com.example.paginationexample.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.paginationexample.apiInterface.RetrofitService
import com.example.paginationexample.model.NETWORK_PAGE_SIZE
import com.example.paginationexample.model.UserList
import com.example.paginationexample.UserListPagingSource

class MainRepository constructor(private  val retrofitService: RetrofitService) {

    fun getAllUserList():LiveData<PagingData<UserList>>{
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false,
            ),
            pagingSourceFactory = {
                UserListPagingSource(retrofitService)
            }
        , initialKey = 1
        ).liveData
    }
}

