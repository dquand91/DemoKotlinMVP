package com.example.demomvpkotlin

import android.Manifest

object AppConfigs {



    /**
     * API and Network
     */
    val HTTP_TIMEOUT: Long = 30

//    val API_HOST = "$HOST$PORT/"
    val API_HOST = "https://reqres.in"

    /**
     * User for permission at runtime.
     */
    val REQUEST_CODE_PERMISSION = 999
    val PERMISSION_CAMERA = Manifest.permission.CAMERA
    val PERMISSION_READ_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE
    val PERMISSION_WRITE_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE
    val PERMISSION_LOCATION =
        arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION)

    /**
     * multi language, =true if has 2 or more language
     */
    var isMultiLanguage = true
    /**
     * Log configs
     */
    val EMPTY = ""
    val LOG_TAG = "MYTAG"

    /**
     * Message configs
     */
    val MESSAGE_SHOWING_DURATION: Long = 1200// in mini-second

    /**
     * Splash screen configs
     */
    val SPLASH_SHOWING_DURATION: Long = 2000// in mini-second

    /**
     * Preference configs
     */
    val PREF_NAME = "my_pref"

    /**
     * MyLanguage config
     */
    val DEFAULT_LANGUAGE = "vi"

    /**
     * LINKS
     */

    val BLANK_WEB = "about:blank"

    val INSTAGRAM_PACKAGE_NAME = "com.instagram.android"


    /**
     * IMAGE
     */
    val IMAGE_TYPE = ".jpg"
    val MAX_IMAGE_AVATAR_SIZE = 200
    val YOUTUBE_TAG = "youtube"



    /**
     * Google map
     */
}