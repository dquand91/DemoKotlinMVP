package com.example.demomvpkotlin.data

import com.example.demomvpkotlin.data.network.client.ApiHelper
import com.example.demomvpkotlin.data.network.response.BaseResponse
import com.example.demomvpkotlin.data.network.usecase.BaseUseCase
import com.example.demomvpkotlin.di.ContextProvider
import com.example.demomvpkotlin.utils.AppLogger
import java.util.logging.Handler
import javax.inject.Inject

class AppDataManager @Inject constructor() : BaseDataManager(),
    BaseUseCase {

    private val TAG = "AppDataManager"

    override fun getDemoData(callBack: DataCallBack<Any>) {
        AppLogger.error(TAG, "getDemoData")
        android.os.Handler().postDelayed({
            callBack.onSuccess((BaseResponse()), "Ok Success")
        }, 3000)
    }





    private fun getApi(): ApiHelper {
        return ContextProvider.provideApi()
    }

//    fun getAccountID(accountID: String, deviceID: String, callBack: DataCallBack<BaseResponse<AccountResponse>>) {
//        // TODO: save tokenID to sharePreference
//        getApi().getAccountByID(deviceID, accountID, handleCallback(callBack))
//    }



}