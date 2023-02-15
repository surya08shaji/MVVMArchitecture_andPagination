package com.example.paginationexample.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.paginationexample.model.UserList
import com.example.paginationexample.repository.MainRepository

class MainViewModel constructor(private val mainRepository: MainRepository): ViewModel() {
    val errorMessage = MutableLiveData<String>()

    fun getMovieList(): LiveData<PagingData<UserList>>{
        return mainRepository.getAllUserList().cachedIn(viewModelScope)
    }
}

