package com.example.demomvpkotlin.data.network.client

import com.example.demomvpkotlin.data.network.base.BaseApiCallBack
import com.example.demomvpkotlin.data.network.response.ErrorResponse
import com.example.demomvpkotlin.utils.AppLogger
import com.google.gson.Gson
import retrofit2.Response

abstract class MyApiCallBack<R: Any> : BaseApiCallBack<R>() {

    override fun handleSuccessResponse(response: Response<R>) {
        try {
            onSuccess(response.body()!!, "OK")
        } catch (ignored: Exception) {
            onError(null, response.message(), ApiClient.ERROR_UNDEFINE_CODE)
        }
    }

    override fun getMessageFromResponse(response: Response<R>): String? {
        var message : String? = null
        var errorJson : String

        try{
            errorJson = response.errorBody()!!.string();
//            val errorResponse = Gson().fromJson<ErrorResponse>(errorJson, ErrorResponse::class.java!!)
//            val errorResponse = Gson().fromJson<ErrorResponse>(errorJson, ErrorResponse::class.java)
//            val errorResponse : ErrorResponse = Gson().fromJson<ErrorResponse>(errorJson, ErrorResponse::class.java)
            val errorResponse = Gson().fromJson(errorJson, ErrorResponse::class.java)
            message = errorResponse.code
            if (message == null || message == "")
                message = response.message()
        } catch(ignored : Exception){
            AppLogger.error("getMessageFromResponse --- $ignored")
            return response.message()
        }
        return message
    }
}

