package com.example.demomvpkotlin.ui.xbase.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.demomvpkotlin.R
import com.example.demomvpkotlin.customview.CustomProgressDialog
import com.example.demomvpkotlin.ui.xbase.presenter.BaseAppPresenter
import com.example.demomvpkotlin.utils.AppLogger

abstract class BaseActivity : AppCompatActivity(), BaseView {

    private var dialog : CustomProgressDialog? = null
    protected lateinit var presenter: BaseAppPresenter<*>

    protected abstract fun initializeDagger()

    protected abstract fun initializePresenter()

    abstract val layoutId: Int


    override fun onCreate(savedInstanceState: Bundle?) {
        AppLogger.lifecycle(this@BaseActivity, "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        initializeDagger()
        initializePresenter()
        presenter.initialize(intent.extras)

    }

    override fun onStart() {
        super.onStart()
        presenter.onViewStart()
        AppLogger.lifecycle(this@BaseActivity, "onStart")
    }

    override fun onStop() {
        super.onStop()
        AppLogger.lifecycle(this@BaseActivity, "onStop")
        presenter.onViewStop()
        hideLoading()
    }

    override fun onDestroy() {
        super.onDestroy()
        AppLogger.lifecycle(this@BaseActivity, "onDestroy")
        presenter.onDetachView()
    }


    override fun showLoading() {
        try {
            if (dialog == null) {
                dialog = createDialogLoading()
            }
            if (!dialog!!.isShowing)
                dialog!!.show()
        } catch (e: Exception) {
            AppLogger.error(e)
        }

    }

    private fun createDialogLoading(): CustomProgressDialog {
        val dialog: CustomProgressDialog
        dialog = CustomProgressDialog(this, R.style.NewLoadingTheme)
        dialog.setOnDismissListener { onHidedLoading() }
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        return dialog
    }

    protected fun onHidedLoading() {

    }

    override fun hideLoading() {
        try {
            dialog?.dismiss()
        } catch (e: Exception) {
            AppLogger.error(e)
        }
    }
}