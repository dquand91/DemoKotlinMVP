package com.example.demomvpkotlin.di

import android.app.Application
import android.support.v7.app.AppCompatActivity
import com.example.demomvpkotlin.App
import com.example.demomvpkotlin.ui.main.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component (modules = [MainModule::class])
interface MainComponent {

//    @Component.Builder
//    interface Builder{
//        @BindsInstance
//        fun application(application: Application): Builder
//
//        fun build(): MainComponent
//    }

    fun inject(activity : MainActivity)

}