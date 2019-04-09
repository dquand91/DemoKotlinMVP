package com.example.demomvpkotlin.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.demomvpkotlin.R
import com.example.demomvpkotlin.utils.AppLogger

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppLogger.error("QUAN123")
    }
}
