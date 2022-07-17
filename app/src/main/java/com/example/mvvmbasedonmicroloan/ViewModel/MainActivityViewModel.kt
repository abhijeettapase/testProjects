package com.example.mvvmbasedonmicroloan.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmbasedonmicroloan.BaseApplication
import com.example.mvvmbasedonmicroloan.MyRepository.MainRepository
import com.example.mvvmbasedonmicroloan.RetrofitServices.APIResponseModel
import com.example.mvvmbasedonmicroloan.di.DaggerViewModelComponent
import com.example.mvvmbasedonmicroloan.utils.StateLiveData
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityViewModel: ViewModel() {

    @Inject
    lateinit var mainRepository: MainRepository


    init {
        DaggerViewModelComponent.builder().appComponent(BaseApplication.appComponent).build().inject(this)
    }

    fun getApiData(): MutableLiveData<List<APIResponseModel>>{

        val response = MutableLiveData<List<APIResponseModel>>()

        viewModelScope.launch {

            mainRepository.getApiData().collect {

                if(it.isNullOrEmpty()){
                    response.value = emptyList()
                }else{
                    response.value = it
                }
            }
        }
        return response
    }

    fun getApiDataUsingStateLiveData(): StateLiveData<List<APIResponseModel>>{
        val response = StateLiveData<List<APIResponseModel>>()

        response.postLoading()

        viewModelScope.launch {
            mainRepository.getApiData().catch { e ->

                response.postError(Throwable("Something went wrong"))

            }.collect { apiData ->

                if(apiData != null){

                    response.postSuccess(apiData)

                }else{
                    response.postError(Throwable("Something went wrong"))
                }

            }

        }


        return response
    }


}