package com.wmt.sajid.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wmt.sajid.models.Example
import com.wmt.sajid.repository.RatesRepo
import kotlinx.coroutines.launch

class MainActivityViewModel:ViewModel() {

    val movieList = MutableLiveData<Example>()
    val loading = MutableLiveData<Boolean>()
    val repo: RatesRepo = RatesRepo()

    fun getAllMovies() {
        viewModelScope.launch {
            val response = repo.getRates()
            if (response.isSuccessful) {
                movieList.postValue(response.body())
                loading.value = false
            } else {
                onError("Error : ${response.message()} ")
            }
        }

    }

    private fun onError(message: String) {
        loading.value = false
    }
}