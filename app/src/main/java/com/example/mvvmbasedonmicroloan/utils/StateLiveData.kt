package com.example.mvvmbasedonmicroloan.utils

import androidx.lifecycle.MutableLiveData

class StateLiveData<T> : MutableLiveData<StateData<T>>() {

    fun postLoading(){
        value = StateData<T>().loading()
    }

    fun postSuccess(data : T){
        value = StateData<T>().success(data)
    }

    fun postError(mError : Throwable){
        value = StateData<T>().error(mError)
    }

    fun postCompleted(){
        value = StateData<T>().completed()
    }

}