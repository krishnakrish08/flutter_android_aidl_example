package com.example.flutter_android_aidl_example

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

class MyAidlService : Service() {
    private val binder = object : IMyAidlInterface.Stub() {
        override fun add(x: Int, y: Int): Int {
            return x + y
        }
    }

    override fun onBind(intent: Intent?): IBinder {
        return binder
    }
}