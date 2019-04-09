package com.example.demomvpkotlin.data.network.base

import com.example.demomvpkotlin.BuildConfig
import com.example.demomvpkotlin.data.network.client.ApiClient.Companion.ERROR_CODE
import com.example.demomvpkotlin.data.network.client.ApiClient.Companion.ERROR_CONNECTION_CODE
import com.example.demomvpkotlin.data.network.client.ApiClient.Companion.ERROR_UNDEFINE_CODE
import com.example.demomvpkotlin.data.network.client.ApiClient.Companion.NO_INTERNET_CODE
import com.example.demomvpkotlin.data.network.client.ApiClient.Companion.RESPONSE_CODE_BAD_REQUEST
import com.example.demomvpkotlin.data.network.client.ApiClient.Companion.RESPONSE_CODE_SUCCESS
import com.example.demomvpkotlin.utils.AppLogger
import retrofit2.Call
import retrofit2.Response

import java.io.IOException
import java.net.ConnectException
import java.util.concurrent.TimeoutException

abstract class BaseApiCallBack<R: Any> : ApiCallback<R> {

    /**
     * @param call
     * @param response
     */
    override fun onResponse(call: Call<R>, response: Response<R>) {
        AppLogger.network("BaseApiCallBack", "onResponse-code", response.code())
        AppLogger.network("BaseApiCallBack", "onResponse-body", response.body());
        AppLogger.network("BaseApiCallBack", "onResponse-message", response.message())
        if (response.code() == RESPONSE_CODE_SUCCESS) {
            if (response.body() != null) {
                handleSuccessResponse(response)
            } else {
                onReceiveResponseError(response)
            }
        } else {
            onReceiveResponseError(response)
        }
    }

    private fun onReceiveResponseError(response: Response<R>) {
        val message = getMessage(response)
        val code = getCode(response, message)
        onError(Throwable(), message, code)
    }

    private fun getCode(response: Response<R>, message: String?): Int {
        var code = ERROR_CODE
        if (response.code() >= RESPONSE_CODE_BAD_REQUEST) {
            code = response.code()
        }
        if (message == null || message == "") {
            code = ERROR_UNDEFINE_CODE
        }
        return code
    }

    private fun getMessage(response: Response<R>): String {
        val message: String
        if (response.body() != null) {
            message = response.message()
        } else {
            message = getMessageFromResponse(response)!!
        }
        return message
    }

    /**
     * @param call
     * @param throwable
     */
    override fun onFailure(call: Call<R>, throwable: Throwable) {
        AppLogger.network("BaseApiCallBack", "onFailure", throwable)
        if (throwable is ConnectException) {
            onError(
                throwable, "Can't connect to server!",
                ERROR_CONNECTION_CODE
            )
        } else if (throwable is TimeoutException) {
            onError(
                throwable, "No response from server!",
                ERROR_CONNECTION_CODE
            )
        } else if (throwable is IOException) {
            onError(
                throwable, "Can't send request! - Please read the above logs.",
                NO_INTERNET_CODE
            )
        } else {
            onError(throwable, throwable.message!!, if (BuildConfig.isEnableLog) ERROR_CODE else ERROR_UNDEFINE_CODE)
        }
    }

}