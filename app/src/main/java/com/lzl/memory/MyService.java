package com.lzl.memory;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import static com.lzl.memory.MyApplication.LZLTAG;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(LZLTAG, "onBind");

        // TODO: Return the communication channel to the service.
        return new Binder();
    }
    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(LZLTAG, "onUnbind");
        return super.onUnbind(intent);
    }
}
