package com.example.demomvpkotlin.ui.xbase

public interface BaseView {

    fun showLoading()

    fun hideLoading()

    fun <M> showMessage(message : M)

}