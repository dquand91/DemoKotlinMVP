package com.example.demomvpkotlin.ui.xbase

interface BasePresenter<V : BaseView> {

    val isViewStop: Boolean

    fun onAttachView(view: V)

    fun onDetachView()

    fun onViewStart()

    fun onViewStop()

}