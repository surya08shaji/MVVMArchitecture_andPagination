package com.example.paginationexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.example.paginationexample.apiInterface.RetrofitService
import com.example.paginationexample.repository.MainRepository
import com.example.paginationexample.adapter.PagingLoadStateAdapter
import com.example.paginationexample.adapter.UserListAdapter
import com.example.paginationexample.databinding.ActivityMainBinding
import com.example.paginationexample.viewModel.MainViewModel
import com.example.paginationexample.viewModelFactory.MainViewModelFactory
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    private  val adapter = UserListAdapter()
    private  val adapterProgressBar = PagingLoadStateAdapter()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofitService = RetrofitService.getInstance()
        val mainRepository = MainRepository(retrofitService)
        binding.recyclerView.adapter = adapter.withLoadStateFooter(PagingLoadStateAdapter())

        viewModel = ViewModelProvider(
            this,MainViewModelFactory(mainRepository)
        ).get(MainViewModel::class.java)

        viewModel.errorMessage.observe(this){
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
        lifecycleScope.launch{
            viewModel.getMovieList().observe(this@MainActivity){
                it?.let {
                    adapter.submitData(lifecycle,it)

                }
            }
        }
    }
}

