package com.example.paginationexample

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paginationexample.apiInterface.RetrofitService
import com.example.paginationexample.model.UserList

class UserListPagingSource(private  val apiService: RetrofitService):PagingSource<Int,UserList>(){


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserList> {
        return try {
            var totalPage = 1
            val position = params.key?: 1
            val response = apiService.getUserList(position)
            totalPage = response.body()?.currentPage?:1

            LoadResult.Page(data = response.body()!!.userList, prevKey = if(position == 1) null else position - 1,
            nextKey = if(position<=totalPage) position + 1 else null)

        } catch (e:Exception){
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, UserList>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)?: state
                .closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

}
