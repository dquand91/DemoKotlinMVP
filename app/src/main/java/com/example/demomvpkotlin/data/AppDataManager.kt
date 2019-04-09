package com.example.demomvpkotlin.data

import com.example.demomvpkotlin.data.network.client.ApiHelper
import com.example.demomvpkotlin.data.network.response.BaseResponse
import com.example.demomvpkotlin.data.network.usecase.BaseUseCase
import com.example.demomvpkotlin.di.ContextProvider

class AppDataManager() : BaseDataManager(),
    BaseUseCase {

    private val TAG = "AppDataManager"

    private fun getApi(): ApiHelper {
        return ContextProvider.provideApi()
    }

//    fun getAccountID(accountID: String, deviceID: String, callBack: DataCallBack<BaseResponse<AccountResponse>>) {
//        // TODO: save tokenID to sharePreference
//        getApi().getAccountByID(deviceID, accountID, handleCallback(callBack))
//    }



}