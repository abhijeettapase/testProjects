package com.example.mvvmbasedonmicroloan.di

import com.example.mvvmbasedonmicroloan.MyRepository.MainRepository
import com.example.mvvmbasedonmicroloan.RetrofitServices.ApiModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ApiModule::class],
dependencies = [AppComponent::class])
interface MainRepositoryComponent {

    fun inject(mainRepository: MainRepository)
}