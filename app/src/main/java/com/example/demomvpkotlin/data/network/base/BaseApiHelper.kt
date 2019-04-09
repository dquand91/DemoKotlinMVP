package com.example.demomvpkotlin.data.network.base

import com.example.demomvpkotlin.data.DataCallBack
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.ArrayList
import java.util.HashMap

abstract class BaseApiHelper<Client> {

    private var client: OkHttpClient? = null
    private var apiClient: Client? = null
    private val callList = ArrayList<Call<*>>()

    constructor(client: OkHttpClient?) {
        this.client = client
    }

    protected fun getClient() : Client{
        if (apiClient == null) {
            client!!.readTimeoutMillis()
            val gson = GsonBuilder()
                .setLenient()
                .create()
            val builder = Retrofit.Builder()
                .baseUrl(provideHost())
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
            val retrofit = builder.build()
            apiClient = retrofit.create(provideClient())
        }
        return apiClient!!
    }

    protected abstract fun provideHost() : String

    protected abstract fun provideClient() : Class<Client>

    public fun resetClient(){
        apiClient = null
    }

    protected fun <R: Any> processRequest(call: Call<R>, dataCallBack: DataCallBack<R>) {
        call.enqueue(handleBase(handle<R>(dataCallBack)))
        // callList.add(call);
    }

    protected abstract fun <R: Any> handle(dataCallBack: DataCallBack<R>): ApiCallback<R>

    fun cancelAllRequests() {
        if (client != null) client!!.dispatcher().cancelAll()
    }


    protected fun <R: Any, C: ApiCallback<R>> handleBase(callback: C?): ApiCallback<R> {
        return object : BaseApiCallBack<R>() {
            override fun getMessageFromResponse(response: Response<R>): String? {
                return callback?.getMessageFromResponse(response)
            }

            override fun handleSuccessResponse(response: Response<R>) {
                callback?.handleSuccessResponse(response)
            }

            override fun onSuccess(response: R, message: String) {
                callback?.onSuccess(response, message)
            }

            override fun onError(throwable: Throwable?, message: String, code: Int) {
                callback?.onError(throwable, message, code)
                callList.clear()
            }
        }
    }

    protected abstract fun getHeaders(token: String?): HashMap<String, Any>

    protected fun getHeaders(): HashMap<String, Any> {
        return getHeaders(null)
    }

    protected fun getParams(myObject: Any): HashMap<String, String>? {
        val type = object : TypeToken<HashMap<String, String>>() {

        }.type
        return Gson().fromJson<HashMap<String, String>>(Gson().toJson(myObject), type)
    }
}