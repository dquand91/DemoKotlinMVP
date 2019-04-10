package com.example.demomvpkotlin.customview

import android.app.ProgressDialog
import android.content.Context
import android.text.TextUtils
import android.view.View
import com.example.demomvpkotlin.R
import kotlinx.android.synthetic.main.x_layout_dialog_loading.*
import kotlinx.android.synthetic.main.x_layout_dialog_loading.view.*

class CustomProgressDialog(context: Context?, theme: Int) : ProgressDialog(context, theme) {

     override fun show() {
        super.show()
        setContentView(R.layout.x_layout_dialog_loading)
//        if (TextUtils.isEmpty(loadingText)) {
//            tvLoadingText.text = "Loading"
//        } else {
//            tvLoadingText.text = loadingText
//        }
         myProgressBar.visibility = View.VISIBLE
    }

}