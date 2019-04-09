package com.example.demomvpkotlin.ui.xbase

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.demomvpkotlin.di.PresenterProvider
import com.example.demomvpkotlin.utils.AppLogger

abstract class BaseActivity<P : BasePresenter<*>> : AppCompatActivity(), BaseView{

    private var presenter: P? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        AppLogger.lifecycle(this@BaseActivity, "onCreate")
        super.onCreate(savedInstanceState)
        if(presenter == null) presenter
    }


    /**
     * @return it's presenter
     */
    fun getPresenter(): P? {
        return presenter
    }

    private fun setPresenter(): P {
        return PresenterProvider().provide(providePresenter())
    }

    protected abstract fun providePresenter(): Class<P>

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun <M> showMessage(message: M) {

    }
}