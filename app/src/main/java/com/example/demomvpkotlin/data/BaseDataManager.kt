package com.example.demomvpkotlin.data

import com.example.demomvpkotlin.data.network.usecase.BaseUseCase

abstract class BaseDataManager : DataManager, BaseUseCase {


    private fun <R : Any> handleCallBack(
        parentCallBack: DataCallBack<R>?,
        callBack: DataCallBack<R>?
    ): DataCallBack<R> {
        return object : DataCallBack<R>() {
            override fun onSuccess(response: R, message: String) {
                if (callBack != null)
                    callBack.onSuccess(response, message)
            }

            override fun onError(throwable: Throwable?, message: String, code: Int) {
                if (parentCallBack != null)
                    parentCallBack.onError(throwable, message, code)
            }
        }
    }

    protected fun <R : Any> handleCallBack(callBack: DataCallBack<R>): DataCallBack<R> {
        return handleCallBack(callBack, callBack)
    }

}