package com.sitthirat.cntandroidtest.util

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

/**
 * Created by PrewSitthirat on 2019-11-27.
 */

class SharedPref(private val mContext: Context) {

    companion object {

        private const val SHARED_PREF_NAME = "CNT_TEST"
        private const val KEY_NAME = "NAME"

    }

    private fun getSharedPref(): SharedPreferences {
        return mContext.getSharedPreferences(SHARED_PREF_NAME, Application.MODE_PRIVATE)
    }

    var name: String
        set(value) {
            getSharedPref().edit().putString(KEY_NAME, value).apply()
        }
        get() {
            return getSharedPref().getString(KEY_NAME, null) ?: ""
        }
}