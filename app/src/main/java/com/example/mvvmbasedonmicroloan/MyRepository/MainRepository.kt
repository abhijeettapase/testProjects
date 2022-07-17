package com.example.mvvmbasedonmicroloan.MyRepository

import com.example.mvvmbasedonmicroloan.BaseApplication
import com.example.mvvmbasedonmicroloan.RetrofitServices.RetrofitService
import com.example.mvvmbasedonmicroloan.di.DaggerMainRepositoryComponent
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainRepository {

    @Inject
    lateinit var mService: RetrofitService

    init {
        DaggerMainRepositoryComponent.builder().appComponent(BaseApplication.appComponent).build().inject(this)
    }


    fun getApiData() = flow{

        mService.getApiData().runCatching {

            when{
                isSuccessful && body() != null ->{

                    emit(body())

                }else ->{
                    emit(null)
                }
            }

        }
    }

    fun getApiDataDirect() = flow{

        val response = mService.getApiData()

        if(response.isSuccessful && response.body() != null){
         emit(response.body())
        }else {
            emit(null)
        }
    }
}