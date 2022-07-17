package com.example.mvvmbasedonmicroloan

import android.app.Application
import com.example.mvvmbasedonmicroloan.di.AppComponent
import com.example.mvvmbasedonmicroloan.di.DaggerAppComponent
import com.example.mvvmbasedonmicroloan.di.module.AppModule

class BaseApplication: Application() {

    companion object{
        lateinit var appComponent: AppComponent
    }



    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}