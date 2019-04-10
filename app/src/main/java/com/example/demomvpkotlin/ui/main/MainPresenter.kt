package com.example.demomvpkotlin.ui.main

import android.os.Bundle
import com.example.demomvpkotlin.data.AppDataManager
import com.example.demomvpkotlin.data.DataCallBack
import com.example.demomvpkotlin.ui.xbase.presenter.BaseAppPresenter
import com.example.demomvpkotlin.utils.AppLogger
import javax.inject.Inject

class MainPresenter
    @Inject constructor(private val mainUseCase: AppDataManager)
    : BaseAppPresenter<MainContract.View>() , MainContract.Presenter{

    private val TAG = "MainPresenter"

    override fun getData() {
        getView()?.showLoading()
        mainUseCase.getDemoData(object : DataCallBack<Any>(){
            override fun onSuccess(response: Any, message: String) {
                AppLogger.error(TAG, "getData --- onSuccess")
                getView()?.let {
                    getView()?.hideLoading()
                    getView()?.onGetDataSuccess()
                }
            }
        })
    }

    override fun initialize(extras: Bundle?) {
        super.initialize(extras)
//        getData()
    }

}
