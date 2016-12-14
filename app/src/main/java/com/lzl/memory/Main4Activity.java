package com.lzl.memory;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

public class Main4Activity extends AppCompatActivity {

    private TextView testTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        this.testTxt = (TextView) findViewById(R.id.test_txt);
        new TestThread(this).start();
    }

    private static class TestThread extends Thread {
        private  Main4Activity activity;
        private WeakReference<Main4Activity> activityRef;

        private TestThread(Main4Activity activity) {
//            this.activity = activity;
            activityRef = new WeakReference<Main4Activity>(activity);
        }

        @Override
        public void run() {
            super.run();
            try {
                TimeUnit.SECONDS.sleep(20);
                showView();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void showView() {
            final Main4Activity act = activityRef.get();
            if (act != null) {
                act.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        act.showTest();
                    }
                });
            }
//            activity.runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    activity.showTest();
//                }
//            });
        }
    }

    private void showTest() {
        testTxt.setVisibility(View.VISIBLE);
    }

}
