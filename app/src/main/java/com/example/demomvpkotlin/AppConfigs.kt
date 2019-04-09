package com.example.demomvpkotlin

import android.Manifest

object AppConfigs {



    /**
     * API and Network
     */
    val HTTP_TIMEOUT: Long = 30

    //    private static final String HOST = "http://115.78.11.247";
    //    private static final String PORT = ":8060";
    private val HOST = "http://neandrtalk.com"
    private val PORT = ""
    private val PORT_DATA = ""

    private val DEV_HOST = "http://115.78.11.247"
    private val DEV_PORT = ":8061"
    private val DEV_PORT_DATA = ":8063"

    //    public static final String API_HOST = HOST + PORT + "/neandrtalk/";
    val API_HOST = "$HOST$PORT/"
    val API_HOST_DATA = HOST + PORT_DATA

    private val ADMIN_HOST = "http://aeonadmin.azurewebsites.net/"
    val SURVEY_URL = ADMIN_HOST + "Survey?cutomerId=1"
    val SURVEY_URL_DEMO = "$API_HOST_DATA/Mobile/Survey?customerId=%d&surveyId=%d&LangCode=%s"
    val MAILER_URL = ADMIN_HOST + "MailerShow?id=1"
    val FIND_BUS_URL = ADMIN_HOST + "CarBus?langCode=vi"

    val API_PROMOTION_HOST_TEST = "https://2018.aeon.oro.com.vn/"
    val API_PROMOTION_HOST_PRODUCT = "https://www.aeon.com.vn/"
    val URL_SURVEY_COMPLETED_BACK_HOME = "http://goto_home_aeon.com/"

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
     * BEACON
     */
    val BEACON_TAG = "table"
    val BEACON_RANGE_IN_METER = 1.5
    val APP_ID_BEACON = "test-aeon-9vp"

    /**
     * Google map
     */
}