package com.example.demomvpkotlin

import android.app.Application
import android.content.Context
import com.example.demomvpkotlin.di.DaggerMainComponent
import com.example.demomvpkotlin.di.MainComponent


class App : Application() {
    var mainComponent : MainComponent? = null

    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        mainComponent = DaggerMainComponent.create()
        context = applicationContext


//        DaggerMainComponent.builder().application(this).build().inject(this)
    }

}