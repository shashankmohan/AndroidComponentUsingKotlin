package com.smaple.demo.demoapp

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class ServiceTest : Service(){

    override fun onBind(p0: Intent?): IBinder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Toast.makeText(this, "Inside Service", Toast.LENGTH_SHORT).show()
        return START_STICKY
    }


    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "Destroy Service", Toast.LENGTH_SHORT).show()
    }


}