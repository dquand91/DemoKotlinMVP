package com.example.demomvpkotlin.ui.xbase.view

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.demomvpkotlin.di.PresenterProvider
import com.example.demomvpkotlin.ui.xbase.presenter.BaseAppPresenter
import com.example.demomvpkotlin.ui.xbase.presenter.BasePresenter
import com.example.demomvpkotlin.utils.AppLogger
import com.example.demomvpkotlin.viewmodel.SharedViewModel


abstract class BaseFragment : Fragment(), BaseView {

    protected var sharedViewModel : SharedViewModel? = null

    protected var presenter : BaseAppPresenter<*>? = null

    abstract val layoutId: Int

    protected abstract fun initializeDagger()

    protected abstract fun initializePresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppLogger.lifecycle(this, "onCreate: $userVisibleHint")
        sharedViewModel =
            ViewModelProviders.of(this!!).get(SharedViewModel::class.java)
        initializeDagger()
        initializePresenter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(layoutId, container,  false)
        presenter?.initialize(arguments)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AppLogger.lifecycle(this, "onActivityCreated: $userVisibleHint")
    }

    override fun onStart() {
        super.onStart()
        AppLogger.lifecycle(this, "onStart: $userVisibleHint")
        presenter?.onViewStart()

    }

    override fun onStop() {
        super.onStop()
        AppLogger.lifecycle(this, "onStop: $userVisibleHint")
        presenter?.onViewStop()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        AppLogger.lifecycle(this, "onDestroyView: $userVisibleHint")

    }

    override fun showLoading() {
        if (activity != null) (activity as BaseActivity).showLoading()
    }

    override fun hideLoading() {
        if (activity != null) (activity as BaseActivity).hideLoading()
    }
}