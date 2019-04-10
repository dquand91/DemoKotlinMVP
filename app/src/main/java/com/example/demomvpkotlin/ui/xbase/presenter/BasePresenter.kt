package com.example.demomvpkotlin.ui.xbase.presenter

import com.example.demomvpkotlin.data.network.usecase.BaseUseCase
import com.example.demomvpkotlin.ui.xbase.view.BaseView

interface BasePresenter<V : BaseView>{

    val isViewStop: Boolean

    fun onAttachView(view: V?)

    fun onDetachView()

    fun onViewStart()

    fun onViewStop()

}