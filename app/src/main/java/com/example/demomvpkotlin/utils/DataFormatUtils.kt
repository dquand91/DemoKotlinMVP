package com.example.demomvpkotlin.utils

import android.os.Bundle
import com.google.gson.GsonBuilder

object DataFormatUtils {

    fun getJsonPretty(data: Any): String? {
        try {
            return GsonBuilder().setPrettyPrinting().create().toJson(data)
        } catch (ignored: Exception) {

        }

        return null
    }

    fun mapToBundle(map: Map<String, String>): Bundle {
        val bundle = Bundle()
        for ((key, value) in map) {
            bundle.putString(key, value)
        }
        return bundle
    }
}