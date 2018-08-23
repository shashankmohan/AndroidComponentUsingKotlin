package com.smaple.demo.demoapp

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

class FragmentTest : Fragment() {

    lateinit var mActivity: MainActivity;
    lateinit var mReceiver: MyReceiver;
    lateinit var intentFilter: IntentFilter;

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.e("FragmentTest onAttach", "onAttach");
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = activity as MainActivity;
        Log.e("FragmentTest onCreate", "onCreate");
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_test, container, false);
        Log.e("Fragment onCreateView", "onCreateView");

        var btnService: Button = view.findViewById(R.id.btn_start_service)
        btnService.setOnClickListener {
            Toast.makeText(mActivity, "Start Service", Toast.LENGTH_SHORT).show()

            val intent = Intent(mActivity, ServiceTest::class.java)
            if (mActivity != null) {
                mActivity.startService(intent)
            }
        }


        var btnStopSevice: Button = view.findViewById(R.id.btn_stop_service)
        btnStopSevice.setOnClickListener {

            val intentStop = Intent(mActivity, ServiceTest::class.java)
            if (mActivity != null) {
                mActivity.stopService(intentStop)
            }
        }

        var btnDynamicBroadCast: Button = view.findViewById(R.id.btn_dynamic_broadcast)
        btnDynamicBroadCast.setOnClickListener {
            var intent = Intent("com.custom_broadcast")
            mActivity.sendBroadcast(intent)
        }

        mReceiver = MyReceiver();
        intentFilter = IntentFilter("com.custom_broadcast")

        return view;
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e("FragTest onActivity", "onActivityCreated");
    }

    override fun onStart() {
        super.onStart()
        Log.e("FragmentTest onStart", "onStart");
        Toast.makeText(mActivity, "FragmentonStart", Toast.LENGTH_SHORT).show()
        //Toast.makeText(mActivity, "onStart", Toast.LENGTH_SHORT).show()
    }


    override fun onResume() {
        super.onResume()
        Log.e("FragmentTest onResume", "onResume");
        mActivity.registerReceiver(mReceiver, intentFilter)
    }


    override fun onPause() {
        super.onPause()
        Log.e("FragmentTest onPause", "onPause");
    }

    override fun onStop() {
        super.onStop()
        Log.e("FragmentTest onStop", "onStop");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("FragmentTest onDestroy", "onDestroy");
        mActivity.unregisterReceiver(mReceiver)

        // java.lang.IllegalArgumentException: Receiver not registered: com.smaple.demo.demoapp.MyReceiver@27b30bf5
        //  mActivity.unregisterReceiver(mReceiver)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("FragTest onDestroyView", "onDestroyView");
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("FragmentTest onDetach", "onDetach");
    }

}
