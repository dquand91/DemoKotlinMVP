package com.example.demomvpkotlin.di

import com.example.demomvpkotlin.data.network.client.ApiHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class MainModule {

//    @Provides
//    @Singleton
//    fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    fun provideApiHelper(appHelper: ApiHelper) : ApiHelper = appHelper




}