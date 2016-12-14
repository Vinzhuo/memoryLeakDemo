package com.lzl.memory;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import static com.lzl.memory.MyApplication.LZLTAG;

public class Main5Activity extends AppCompatActivity {

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(LZLTAG, "onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(LZLTAG, "onServiceDisconnected");
        }
    };
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, 1000);
            }
        }, 3 * 1000);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
