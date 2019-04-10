package com.example.demomvpkotlin.ui.main

import android.os.Bundle
import android.os.Handler
import com.example.demomvpkotlin.App
import com.example.demomvpkotlin.R
import com.example.demomvpkotlin.data.network.usecase.BaseUseCase
import com.example.demomvpkotlin.ui.xbase.view.BaseActivity
import com.example.demomvpkotlin.utils.AppLogger
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

    private val TAG = "MainActivity"

    @Inject
    lateinit var mainPresenter: MainPresenter


    override fun initializeDagger() {
        val app = applicationContext as App
        app.mainComponent?.inject(this@MainActivity)

    }

    override fun initializePresenter() {
        mainPresenter.setView(this)
        super.presenter = mainPresenter
    }

    override val layoutId: Int
        get() = R.layout.activity_main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppLogger.error(TAG, "onCreate")
        Handler().postDelayed({
            mainPresenter.getData()}, 3000)
    }

    override fun onGetDataSuccess() {
        AppLogger.error(TAG, "onGetDataSuccess")
    }
}
