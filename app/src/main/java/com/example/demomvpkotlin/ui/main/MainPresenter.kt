package com.example.demomvpkotlin.ui.main

import android.os.Bundle
import com.example.demomvpkotlin.data.AppDataManager
import com.example.demomvpkotlin.data.DataCallBack
import com.example.demomvpkotlin.data.network.response.DataItem
import com.example.demomvpkotlin.data.network.response.DemoResponse
import com.example.demomvpkotlin.ui.xbase.presenter.BaseAppPresenter
import com.example.demomvpkotlin.utils.AppLogger
import javax.inject.Inject

class MainPresenter
    @Inject constructor(private val mainUseCase: AppDataManager)
    : BaseAppPresenter<MainContract.View>() , MainContract.Presenter{

    private val TAG = "MainPresenter"

    override fun getData() {
        getView()?.showLoading()
        mainUseCase.getDemoData(object : DataCallBack<DemoResponse>(){
            override fun onSuccess(response: DemoResponse, message: String) {
                AppLogger.error(TAG, "getData --- onSuccess")
                AppLogger.error(TAG, "getData --- onSuccess ---- $response")
                getView()?.let {
                    getView()?.hideLoading()
                    getView()?.onGetDataSuccess(response.data as List<DataItem>)
                }
            }
        })
    }

    override fun initialize(extras: Bundle?) {
        super.initialize(extras)
//        getData()
    }

}
