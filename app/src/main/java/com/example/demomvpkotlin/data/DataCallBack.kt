package com.example.demomvpkotlin.data

abstract class DataCallBack<R> {
    /**
     * @param response
     * @param message
     */
    abstract fun onSuccess(response: R, message: String)

    /**
     * @param throwable ...
     * @param message   Error message!
     * @param code      Error code.
     */
    open fun onError(throwable: Throwable?, message: String, code: Int) {

    }

    /**
     * @param message   Error message!
     * @param code      Error code.
     */
    fun onResponse(response: R, message: String, code: Int) {

    }
}