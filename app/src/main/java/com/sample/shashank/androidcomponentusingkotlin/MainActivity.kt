package com.smaple.demo.demoapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("onCreate", "onCreate");
        val fragment = FragmentTest();
        val fm = supportFragmentManager;
        val ft = fm.beginTransaction();
        ft.replace(R.id.ll_container, fragment, "fragment")
        ft.commit()
    }


    override fun onStart() {
        super.onStart()
        Log.e("onStart", "onStart");
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.e("onResume", "onResume");
    }

    override fun onPause() {
        super.onPause()
        Log.e("onPause", "onPause");
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("onRestart", "onRestart");
    }

    override fun onStop() {
        super.onStop()
        Log.e("onStop", "onStop");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "onDestroy");
    }

}
