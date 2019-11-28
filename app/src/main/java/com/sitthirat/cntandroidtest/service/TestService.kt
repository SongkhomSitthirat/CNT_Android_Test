package com.sitthirat.cntandroidtest.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

/**
 * Created by PrewSitthirat on 2019-11-28.
 */

class TestService : Service() {

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        toastService(startId)
        return START_STICKY
    }

    private fun toastService(startId: Int) {
        Toast.makeText(this.applicationContext, "Start Service success!!", Toast.LENGTH_SHORT).show()
        stopSelf(startId)
    }
}