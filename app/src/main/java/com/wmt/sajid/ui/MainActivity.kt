package com.wmt.sajid.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.wmt.sajid.R
import com.wmt.sajid.databinding.ActivityMainBinding
import com.wmt.sajid.models.Example
import com.wmt.sajid.models.Results
import com.wmt.sajid.ui.adapter.UsersAdapter

class MainActivity : AppCompatActivity() {

    lateinit var activityMainBinding: ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel
    lateinit var arrayList1: ArrayList<Results>
    var usersAdapter: UsersAdapter = UsersAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.movieList.observe(this,{
            arrayList1= ArrayList()
            arrayList1.addAll(it.results)
            activityMainBinding.recyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
            activityMainBinding.recyclerView.adapter=usersAdapter
            activityMainBinding.recyclerView.itemAnimator= DefaultItemAnimator()
            usersAdapter.setMovieList(arrayList1)
        })
        viewModel.loading.observe(this,{
            if (!it){
                activityMainBinding.progressBar.visibility= View.GONE
            }
        })
        activityMainBinding.progressBar.visibility= View.VISIBLE
        viewModel.getAllMovies()
    }
}