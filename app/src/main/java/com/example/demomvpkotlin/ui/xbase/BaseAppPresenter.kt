package com.example.demomvpkotlin.ui.xbase

import android.app.Application
import android.widget.Toast
import com.example.demomvpkotlin.data.DataCallBack
import com.example.demomvpkotlin.data.network.usecase.BaseUseCase
import com.example.demomvpkotlin.di.ContextProvider
import com.example.demomvpkotlin.utils.AppLogger
import java.lang.ref.SoftReference
abstract class BaseAppPresenter<V : BaseView, U : BaseUseCase> : BasePresenter<V> {


    private val TAG = "BaseAppPresenter"
    protected var isLoadingData = false
    private var isCallHideLoading: Boolean = false
    private var view: SoftReference<V>? = null
    private var mIsViewStop = false

    fun getView(): V? = view?.get()

    fun getUseCase() : U? = ContextProvider.provideDataManager() as U

    override fun onAttachView(view: V) {
        this.view = SoftReference(view)
    }

    override fun onDetachView() {
        if (this.view != null){
            this.view!!.clear()
        }
        this.view = null
    }

    override fun onViewStart() {
        mIsViewStop = false
        if(isCallHideLoading) hideLoading()
    }

    override fun onViewStop() {
        mIsViewStop = true
    }

    override val isViewStop: Boolean
        get() = mIsViewStop


    protected fun showLoading(isShowViewLoading: Boolean) {
        isLoadingData = true
        try {
            if (getView() != null) {
                if (isShowViewLoading)
                    getView()!!.showLoading()
            }
        } catch (e: Exception) {
            AppLogger.error(e)
        }
    }

    protected fun hideLoading() {
        isLoadingData = false
        if (isViewStop) return
        if (getView() == null) return
        getView()!!.hideLoading()
        isCallHideLoading = false
    }

    protected fun <R : Any> handleCallBack(hideLoadingView: Boolean, callBack: DataCallBack<R>): DataCallBack<R> {
        return handleCallBack(hideLoadingView, false, callBack)
    }

    protected fun <R : Any> handleCallBack(hideLoadingView: Boolean, isSilence: Boolean, callback : DataCallBack<R>) : DataCallBack<R>{
        return object : DataCallBack<R>(){
            override fun onSuccess(response: R, message: String) {
                if(hideLoadingView){
                    isCallHideLoading = true
                    hideLoading()
                }else{
                    isLoadingData = false
                }
                callback.onSuccess(response, message)
            }

            override fun onError(throwable: Throwable?, message: String, code: Int) {
                isCallHideLoading = true
                hideLoading()
                if(getView() != null && !isSilence){
                    AppLogger.error("BaseAppPresenter - onError - $message --- $code")
                    Toast.makeText(ContextProvider.provideContext(), message, Toast.LENGTH_SHORT)
                }
                callback.onError(throwable, message, code)
            }
        }
    }
}

