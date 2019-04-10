package com.example.demomvpkotlin.ui.xbase

interface BaseCallback {

    fun onSuccess(newsModel: BaseModel)

    fun onFail()
}