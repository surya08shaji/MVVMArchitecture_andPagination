package com.example.paginationexample.apiInterface

import com.example.paginationexample.model.UserListResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("users")
    suspend fun getUserList(
        @Query("currentPage")currentPage:Int
    ):Response<UserListResponse>

    companion object{
        private var retrofitService:RetrofitService? = null
        fun getInstance(): RetrofitService{
            if (retrofitService == null){
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://aa298c33-127b-407d-90a3-cfe36d27309a.mock.pstmn.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}
