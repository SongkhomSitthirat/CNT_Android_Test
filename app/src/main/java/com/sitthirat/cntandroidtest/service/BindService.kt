package com.sitthirat.cntandroidtest.service

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.os.*
import android.widget.Toast
import com.sitthirat.cntandroidtest.view.main.second.SecondFragment

/**
 * Created by PrewSitthirat on 2019-11-28.
 */

class BindService : Service() {

    private val binder = LocalBinder()

    override fun onBind(intent: Intent?): IBinder? = binder

    fun toastBindServiceSuccess() {
        Toast.makeText(applicationContext, "Bind Service success!!!", Toast.LENGTH_SHORT).show()
        stopSelf()
    }

    inner class LocalBinder : Binder() {
        fun getService(): BindService = this@BindService
    }
}