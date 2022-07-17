package com.example.mvvmbasedonmicroloan.di.module

import com.example.mvvmbasedonmicroloan.BaseApplication
import dagger.Module
import dagger.Provides

@Module
class AppModule constructor(private val app: BaseApplication){

    @Provides
    fun provideMainApp(): BaseApplication = app

}