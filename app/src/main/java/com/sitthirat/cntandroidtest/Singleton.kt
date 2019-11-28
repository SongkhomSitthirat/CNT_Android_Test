package com.sitthirat.cntandroidtest

import android.content.Context
import android.widget.Toast

/**
 * Created by PrewSitthirat on 2019-11-27.
 */

object Singleton {

    fun say(mContext: Context) {
        Toast.makeText(mContext, "I am singleton", Toast.LENGTH_SHORT).show()
    }
}