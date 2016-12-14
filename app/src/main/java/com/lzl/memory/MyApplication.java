package com.lzl.memory;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.StrictMode;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.squareup.leakcanary.LeakCanary;

import java.util.concurrent.TimeUnit;

/**
 * Created by liuzhuolin on 2016/12/12.
 */

public class MyApplication extends Application {
    public static final String  LZLTAG = "memoryTest";
    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onCreate() {

        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        this.bindService(new Intent(this, MyService.class), new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        }, Context.BIND_AUTO_CREATE);
    }
}
