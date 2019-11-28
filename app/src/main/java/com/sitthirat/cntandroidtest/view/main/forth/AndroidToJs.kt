package com.sitthirat.cntandroidtest.view.main.forth

import android.content.Context
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.widget.Toast

/**
 * Created by PrewSitthirat on 2019-11-27.
 */

class AndroidToJs(private val mContext: Context) {

    @JavascriptInterface
    fun hello(text: String) {
        Toast.makeText(mContext, text, Toast.LENGTH_SHORT).show()
    }

    @JavascriptInterface
    fun toastFirstLine(text: String) {
        val listString = text.split("\n")
        if (listString.isNotEmpty()) {
            Toast.makeText(mContext, listString[0], Toast.LENGTH_SHORT).show()
        }
    }

}