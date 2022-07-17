package com.example.mvvmbasedonmicroloan.RetrofitServices

import com.example.mvvmbasedonmicroloan.Constants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class ApiModule {

    @Singleton
    @Provides
    fun getRetrofitServise(retrofit: Retrofit): RetrofitService{
        return retrofit.create(RetrofitService::class.java)
    }

    @Singleton
    @Provides
    fun getRetrofitInstance():Retrofit{


        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.readTimeout(10, TimeUnit.MINUTES)
        httpClient.writeTimeout(10, TimeUnit.MINUTES)
        httpClient.connectTimeout(10, TimeUnit.MINUTES)
        httpClient.addInterceptor(logging)


        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
    }
}