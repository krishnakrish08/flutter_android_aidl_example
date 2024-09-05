package com.example.flutter_android_aidl_example

import android.content.ComponentName;
import android.content.Context
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import com.example.flutter_android_aidl_example.IMyAidlInterface;

class MainActivity : FlutterActivity() {
    private val CHANNEL = "com.example.myapp/aidl"
    private var aidlService: IMyAidlInterface? = null

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            aidlService = IMyAidlInterface.Stub.asInterface(service)
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            aidlService = null
        }
    }

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(
            flutterEngine.dartExecutor.binaryMessenger,
            CHANNEL
        ).setMethodCallHandler { call, result ->
            if (call.method == "add") {
                val x = call.argument<Int>("x")!!
                val y = call.argument<Int>("y")!!
                val sum = aidlService?.add(x, y) ?: 0
                result.success(sum)
            } else {
                result.notImplemented()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val intent = Intent(this, MyAidlService::class.java)
        bindService(intent, connection, Context.BIND_AUTO_CREATE)
    }

    override fun onStop() {
        super.onStop()
        unbindService(connection)
    }
}
