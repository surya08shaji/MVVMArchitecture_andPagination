package com.example.paginationexample.model

const val NETWORK_PAGE_SIZE = 1

data class UserListResponse(
    val currentPage: Int,
    val userList: List<UserList>
)

data class UserList(
    val name : String,
    val location: String,
    val state: String,
    val country: String
)
