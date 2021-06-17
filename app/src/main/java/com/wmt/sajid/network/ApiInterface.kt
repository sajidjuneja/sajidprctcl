package com.wmt.sajid.network

import com.wmt.sajid.models.Example
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("api/?page=1&results=25")
    suspend fun getRates(): Response<Example>
}