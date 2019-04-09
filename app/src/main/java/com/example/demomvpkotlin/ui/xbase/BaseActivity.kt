package com.example.demomvpkotlin.ui.xbase

import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.demomvpkotlin.R
import com.example.demomvpkotlin.customview.CustomProgressDialog
import com.example.demomvpkotlin.di.PresenterProvider
import com.example.demomvpkotlin.utils.AppLogger

abstract class BaseActivity<P : BasePresenter<BaseView>> : AppCompatActivity(), BaseView{

    private var presenter: P? = null
    private var dialog : CustomProgressDialog? = null

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


    override fun onCreate(savedInstanceState: Bundle?) {
        AppLogger.lifecycle(this@BaseActivity, "onCreate")
        super.onCreate(savedInstanceState)
        if(presenter == null) presenter
        presenter!!.onAttachView(this@BaseActivity)
    }

    override fun onStart() {
        super.onStart()
        AppLogger.lifecycle(this@BaseActivity, "onStart")
        getPresenter()!!.onViewStop()
    }

    override fun onStop() {
        super.onStop()
        AppLogger.lifecycle(this@BaseActivity, "onStop")
        hideLoading()
        getPresenter()!!.onViewStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        AppLogger.lifecycle(this@BaseActivity, "onDestroy")
        presenter?.onDetachView()
        presenter = null
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