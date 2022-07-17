package com.example.mvvmbasedonmicroloan.di.module

import com.example.mvvmbasedonmicroloan.MyRepository.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository() = MainRepository()

}