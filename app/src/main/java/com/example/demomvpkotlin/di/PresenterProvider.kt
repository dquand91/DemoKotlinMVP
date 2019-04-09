package com.example.demomvpkotlin.di

import com.example.demomvpkotlin.ui.xbase.BasePresenter

public  class PresenterProvider {

    private fun matched(classTypeSource: Class<*>, classTypeDestination: Class<*>): Boolean {
        return classTypeSource.canonicalName.equals(classTypeDestination.canonicalName)
    }

    open fun <P : BasePresenter<*>> provide(classType: Class<P>): P {
//        if (matched(classType, MainContract.Presenter::class.java!!)) {
//            return MainPresenter()
//        }
        throw IllegalArgumentException("Add [" + classType.canonicalName + "]" + " to Presenter Provider!!!")
    }






}