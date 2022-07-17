package com.example.mvvmbasedonmicroloan.di

import com.example.mvvmbasedonmicroloan.ViewModel.MainActivityViewModel
import com.example.mvvmbasedonmicroloan.di.module.RepositoryModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RepositoryModule::class], dependencies = [AppComponent::class])
interface ViewModelComponent {

fun inject(mainActivityViewModel: MainActivityViewModel)

}