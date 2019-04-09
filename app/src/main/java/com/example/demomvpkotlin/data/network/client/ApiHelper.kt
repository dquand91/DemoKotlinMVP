package com.example.demomvpkotlin.data.network.client

import com.example.demomvpkotlin.AppConfigs
import com.example.demomvpkotlin.data.CallBackHandler
import com.example.demomvpkotlin.data.DataCallBack
import com.example.demomvpkotlin.data.network.base.ApiCallback
import com.example.demomvpkotlin.data.network.base.BaseApiHelper
import okhttp3.OkHttpClient
import java.util.HashMap

class ApiHelper(client: OkHttpClient) : BaseApiHelper<ApiClient>(client) {


    override fun provideHost(): String = AppConfigs.API_HOST

    override fun provideClient(): Class<ApiClient> = ApiClient::class.java

    override fun <R : Any> handle(dataCallBack: DataCallBack<R>): ApiCallback<R> {
        return CallBackHandler.handle(this@ApiHelper, dataCallBack)
    }

    override fun getHeaders(token: String?): HashMap<String, Any> {
        val headers = HashMap<String, Any>()
        if (token != null)
            headers[ApiClient.HEADER_AUTHORIZATION] = token
        headers[ApiClient.HEADER_CONTENT_TYPE] = ApiClient.HEADER_CONTENT_TYPE_VALUE_JSON
        return headers
    }


//    fun login(
//        userName: String,
//        password: String,
//        callBack: DataCallBack<LoginResponse>
//    ) {
//        //        String os = "Android " + Build.VERSION.RELEASE;
//        //        String deviceName = Build.BRAND + " " + Build.MODEL.replaceAll(Build.BRAND, "");
//        //        deviceName = deviceName.replace("  ", " ");
//        processRequest(
//            getClient().login(
//                getHeaders(),
//                LoginParam(userName, password)
//            ), callBack
//        )
//    }
}