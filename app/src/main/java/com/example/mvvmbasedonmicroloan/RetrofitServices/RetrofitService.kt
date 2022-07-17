package com.example.mvvmbasedonmicroloan.RetrofitServices

import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {

    @GET("products")
    suspend fun getApiData(): Response<List<APIResponseModel>>
}