package com.example.demomvpkotlin.ui.xbase

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.demomvpkotlin.di.PresenterProvider
import com.example.demomvpkotlin.utils.AppLogger
import com.example.demomvpkotlin.viewmodel.SharedViewModel


abstract class BaseFragment<P : BasePresenter<BaseView>> : Fragment(), BaseView {

    private var presenter : P? = null
    protected var sharedViewModel : SharedViewModel? = null

    public fun getPresenter(): P? {
        if (presenter == null) {
            presenter = setPresenter()
            presenter!!.onAttachView(this)
        }
        return presenter
    }

    private fun setPresenter() = PresenterProvider().provide(providePresenter())

    protected abstract fun providePresenter(): Class<P>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppLogger.lifecycle(this, "onCreate: $userVisibleHint")
        sharedViewModel =
            ViewModelProviders.of(this!!).get(SharedViewModel::class.java)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AppLogger.lifecycle(this, "onActivityCreated: $userVisibleHint")
        if (presenter != null) presenter!!.onAttachView(this)
    }

    override fun onStart() {
        super.onStart()
        AppLogger.lifecycle(this, "onStart: $userVisibleHint")
        if (userVisibleHint)
            getPresenter()!!.onViewStart()
    }

    override fun onStop() {
        super.onStop()
        AppLogger.lifecycle(this, "onStop: $userVisibleHint")
        getPresenter()!!.onViewStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        AppLogger.lifecycle(this, "onDestroyView: $userVisibleHint")
        if (presenter != null) presenter!!.onDetachView()
    }

    override fun showLoading() {
        if (activity != null) (activity as BaseActivity<*>).showLoading()
    }

    override fun hideLoading() {
        if (activity != null) (activity as BaseActivity<*>).hideLoading()
    }
}