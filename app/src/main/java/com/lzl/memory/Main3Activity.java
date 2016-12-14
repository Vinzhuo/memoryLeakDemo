package com.lzl.memory;

import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class Main3Activity extends AppCompatActivity {

    private Timer timer;

    private TimerTask timerTask = new TestTimerTask();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

            }
        }, 1000, 1000);
    }

    private static class TestTimerTask extends  TimerTask {

        @Override
        public void run() {

        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }
}
