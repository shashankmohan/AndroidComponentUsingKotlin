package com.smaple.demo.demoapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver(){


    override fun onReceive(p0: Context?, p1: Intent?) {

        Toast.makeText(p0, "Inside BroadCast" + p1?.action, Toast.LENGTH_SHORT).show()

        p0?.startService(Intent(p0, ServiceTest::class.java))
    }

}