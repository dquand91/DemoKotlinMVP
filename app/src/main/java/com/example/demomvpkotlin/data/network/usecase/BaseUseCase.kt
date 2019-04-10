package com.example.demomvpkotlin.data.network.usecase

import com.example.demomvpkotlin.data.DataCallBack
import com.example.demomvpkotlin.data.network.response.DemoResponse

interface BaseUseCase {

    fun getDemoData(callBack: DataCallBack<DemoResponse>)


}