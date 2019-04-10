package com.example.demomvpkotlin.data.network.usecase

import com.example.demomvpkotlin.data.DataCallBack

interface BaseUseCase {

    fun getDemoData(callBack: DataCallBack<Any>)


}