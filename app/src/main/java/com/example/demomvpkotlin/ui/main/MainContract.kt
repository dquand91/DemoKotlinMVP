package com.example.demomvpkotlin.ui.main

import com.example.demomvpkotlin.data.network.usecase.BaseUseCase
import com.example.demomvpkotlin.ui.xbase.contract.BaseContract
import com.example.demomvpkotlin.ui.xbase.presenter.BasePresenter
import com.example.demomvpkotlin.ui.xbase.view.BaseView

class MainContract : BaseContract() {

    public interface Presenter{
          fun getData()
    }

    interface View : BaseView{
        fun onGetDataSuccess()
    }

}