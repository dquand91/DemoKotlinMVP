package com.example.demomvpkotlin.ui.main

import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutCompat
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.example.demomvpkotlin.App
import com.example.demomvpkotlin.R
import com.example.demomvpkotlin.data.network.response.DataItem
import com.example.demomvpkotlin.ui.main.adapter.DemoAdapter
import com.example.demomvpkotlin.ui.xbase.view.BaseActivity
import com.example.demomvpkotlin.utils.AppLogger
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

    lateinit var mAdapter : DemoAdapter

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
        initRecyclerView()


        btnDemo.setOnClickListener {
            mainPresenter.getData()
        }
    }

    override fun onGetDataSuccess(list : List<DataItem>) {
        AppLogger.error(TAG, "onGetDataSuccess")
        AppLogger.error(TAG, "onGetData1312321321Success")
        mAdapter.updateList(list)
    }

    fun initRecyclerView(){
        mAdapter = DemoAdapter(this)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = mAdapter



    }
}
