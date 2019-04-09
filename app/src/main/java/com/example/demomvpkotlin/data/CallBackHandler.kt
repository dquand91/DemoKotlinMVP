package com.example.demomvpkotlin.data

import com.example.demomvpkotlin.data.network.base.ApiCallback
import com.example.demomvpkotlin.data.network.base.BaseApiHelper
import com.example.demomvpkotlin.data.network.client.ApiHelper
import com.example.demomvpkotlin.data.network.client.MyApiCallBack
import com.example.demomvpkotlin.utils.AppLogger

class CallBackHandler {

    companion object {
        @JvmStatic
        fun <R : Any> handle(apiHelper: BaseApiHelper<*>, dataCallBack: DataCallBack<R>): ApiCallback<R> {
            if (apiHelper is ApiHelper) return handleMyApi(
                dataCallBack
            )
            throw NullPointerException("No api helper instance")
        }

        private fun <R : Any> handleMyApi(dataCallBack: DataCallBack<R>): ApiCallback<R> {
            return object : MyApiCallBack<R>() {
                override fun onSuccess(response: R, message: String) {
                    dataCallBack?.onSuccess(response, message)
                }

                override fun onError(throwable: Throwable?, message: String, code: Int) {
                    AppLogger.network("BaseApiHelper", "handleError", "$message:$code")

                    if (dataCallBack == null) return


                    dataCallBack.onError(throwable, message, code)

                }

            }
        }
    }




}