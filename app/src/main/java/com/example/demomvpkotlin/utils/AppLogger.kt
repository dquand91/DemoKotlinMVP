package com.example.demomvpkotlin.utils

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import com.example.demomvpkotlin.AppConfigs
import com.example.demomvpkotlin.BuildConfig

object AppLogger {
    private val TYPE_DEBUG = 0
    private val TYPE_ERROR = 1
    private val TYPE_VERBOSE = 2
    private val TYPE_INFO = 3
    private val lifeCycleLogOn = true


    fun <T> error(message: T) {
        showLog(TYPE_ERROR, AppConfigs.LOG_TAG, "", message)
    }

    fun <T> error(`object`: Any, message: T) {
        error(`object`.javaClass.simpleName, message)
    }

    fun <T> error(prefix: String, message: T) {
        showLog(TYPE_ERROR, AppConfigs.LOG_TAG, prefix, message)
    }

    fun <T> debug(message: T) {
        showLog(TYPE_DEBUG, AppConfigs.LOG_TAG, "", message)
    }

    fun <T> debug(`object`: Any, message: T) {
        debug(`object`.javaClass.simpleName, message)
    }

    fun <T> debug(prefix: String, message: T) {
        showLog(TYPE_DEBUG, AppConfigs.LOG_TAG, prefix, message)
    }

    fun <T> network(`object`: Any, action: String, message: T) {
        var prefix = ""
        if (`object` is String) {
            prefix = `object`
        } else
            prefix = `object`.javaClass.simpleName
        showLog(TYPE_DEBUG, "MY_CLIENT", "$prefix($action)", message)
    }

    fun <T> lifecycle(`object`: Any, message: T) {
        if (AppLogger.lifeCycleLogOn)
            showLog(TYPE_DEBUG, "MY_LIFECYCLE", `object`.javaClass.simpleName, message)
    }

    fun <T> memory(message: T) {
        showLog(TYPE_INFO, "MY_MEMORY", "", message)
    }

    private fun <T> showLog(type: Int, tag: String, prefix: String?, message: T) {
        if (!BuildConfig.isEnableLog) return
        var prefixString = ""
        if (prefix != null && prefix.length > 0) prefixString = "[$prefix] "
        val messageString = getMessage(message)
        when (type) {
            TYPE_DEBUG -> Log.d(tag, prefixString + messageString)
            TYPE_ERROR -> Log.e(tag, prefixString + messageString)
            TYPE_VERBOSE -> Log.e(tag, prefixString + messageString)
            TYPE_INFO -> Log.e(tag, prefixString + messageString)
            else -> Log.e(tag, prefixString + messageString)
        }

    }

    private fun <T> getMessage(message: T?): String {
        if (message == null) return "NULL!!!"
        var messageString: String? = "Unknown!"
        if (message is Exception) {
            messageString = ("[" + (message as Exception).javaClass.simpleName + "]"
                    + (message as Exception).message)
        } else if (message is Throwable) {
            messageString = ("[" + (message as Throwable).javaClass.simpleName + "]"
                    + (message as Throwable).message)
        } else {
            if (message is String
                || message is Boolean
                || message is Float
                || message is Int
                || message is Long
            ) {
                messageString = message.toString()
            } else if (message is Intent) {
                val intentData = IntentData()
                intentData.setData(message as Intent)
                messageString = DataFormatUtils.getJsonPretty(intentData)
            } else if (message is Bundle) {
                messageString = (message as Bundle).toString()
            } else {
                try {
                    messageString = DataFormatUtils.getJsonPretty(message)
                } catch (e: Exception) {
                    messageString = message.toString()
                }

            }
        }
        return messageString ?: "NULL!!!"
    }

    class IntentData {

        var dataPath: String? = ""
        var bundleData: String? = ""
        fun setData(intent: Intent) {
            setPath(intent.data)
            val data = intent.extras
            if (data != null) bundleData = data.toString()
        }

        private fun setPath(data: Uri?) {
            if (data != null) dataPath = data.path
        }
    }
}