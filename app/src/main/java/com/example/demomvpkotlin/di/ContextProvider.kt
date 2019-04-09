package com.example.demomvpkotlin.di

import android.annotation.SuppressLint
import android.content.Context
import com.example.demomvpkotlin.AppConfigs
import com.example.demomvpkotlin.BuildConfig
import com.example.demomvpkotlin.data.AppDataManager
import com.example.demomvpkotlin.data.DataManager
import com.example.demomvpkotlin.data.network.client.ApiHelper
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

@SuppressLint("StaticFieldLeak")
object ContextProvider {
    private var context: Context? = null
    private var apiHelper: ApiHelper? = null
    private var dataManager: DataManager? = null

    fun setContext(context: Context) {
        ContextProvider.context = context
    }

    fun release() {
        context = null
    }

    fun provideContext(): Context? {
        return context
    }


    @Synchronized
    fun provideApi(): ApiHelper {
        if (apiHelper == null) apiHelper = ApiHelper(provideHttpClient())
        return apiHelper!!
    }

    @Synchronized
    fun provideDataManager(): DataManager {
        if (dataManager == null) {
            dataManager = AppDataManager()
        }
        return dataManager!!
    }


    fun provideHttpClient(): OkHttpClient {
        var builder: OkHttpClient.Builder = OkHttpClient.Builder()
            .connectTimeout(AppConfigs.HTTP_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(AppConfigs.HTTP_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(AppConfigs.HTTP_TIMEOUT, TimeUnit.SECONDS)
        if (BuildConfig.isEnableLog) {
            val interceptor = HttpLoggingInterceptor()
            // Change to HttpLoggingInterceptor.Level.BODY to print full detail LOG of http request/response
//            interceptor.level = HttpLoggingInterceptor.Level.BASIC
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder = builder
                .addNetworkInterceptor(StethoInterceptor())
                .addInterceptor(interceptor)
        }
        //        builder = builder.addInterceptor(new Interceptor() {
        //            @Override
        //            public Response intercept(Chain chain) throws IOException {
        //                Request request = chain
        //                        .request()
        //                        .newBuilder()
        //                        .addHeader(
        //                                "User-Agent",
        //                                BuildConfig.APPLICATION_ID + "/" + BuildConfig.VERSION_NAME + "/" + "Android"+"/"+(BuildConfig.isEnableLog?"TEST":"RELEASE"))
        //                        .build();
        //                return chain.proceed(request);
        //            }
        //        });
        return builder.build()
    }
}