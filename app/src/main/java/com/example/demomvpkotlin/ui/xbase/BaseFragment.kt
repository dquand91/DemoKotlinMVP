package com.example.demomvpkotlin.ui.xbase

import android.support.v4.app.Fragment

abstract class BaseFragment<P : BasePresenter<*>> : Fragment(), BaseView {



}