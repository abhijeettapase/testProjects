package com.example.mvvmbasedonmicroloan.di

import com.example.mvvmbasedonmicroloan.BaseApplication
import com.example.mvvmbasedonmicroloan.RetrofitServices.ApiModule
import com.example.mvvmbasedonmicroloan.di.module.AppModule
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {

    fun app() : BaseApplication

}