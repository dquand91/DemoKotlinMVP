package com.example.demomvpkotlin.data.network.response

import com.google.gson.annotations.SerializedName

class ErrorResponse {
    @SerializedName("code")
    var code: String? = null

    @SerializedName("message")
    var message: String? = null


    override fun toString(): String {
        return "ErrorResponse{" +
                "code = '" + code + '\''.toString() +
                ",message = '" + message + '\''.toString() +
                "}"
    }
}