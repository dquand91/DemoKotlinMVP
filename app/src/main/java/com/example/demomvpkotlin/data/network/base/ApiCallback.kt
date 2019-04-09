package com.example.demomvpkotlin.data.network.base

import retrofit2.Callback
import retrofit2.Response

interface ApiCallback<R> : Callback<R> {

    fun getMessageFromResponse(response: Response<R>): String?

    fun handleSuccessResponse(response: Response<R>)

    fun onSuccess(response: R, message: String)

    fun onError(throwable: Throwable?, message: String, code: Int)


}