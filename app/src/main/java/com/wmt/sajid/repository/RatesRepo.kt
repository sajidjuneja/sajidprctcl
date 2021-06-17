package com.wmt.sajid.repository

import com.wmt.sajid.network.ApiClient

class RatesRepo {

    private val apiInterface= ApiClient.apiService

    suspend fun getRates()=apiInterface.getRates()
}