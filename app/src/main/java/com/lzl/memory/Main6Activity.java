package com.lzl.memory;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class Main6Activity extends AppCompatActivity {

    private static TextView textView;
    private ViewGroup rootView;
    private static WeakReference<List> listWeakReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        rootView = (ViewGroup) findViewById(R.id.activity_main6);
        textView = (TextView) findViewById(R.id.test_txt);
        List<Activity> dds = new ArrayList<>(7);
        dds.add(this);
        listWeakReference = new WeakReference<List>(dds);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        textView = null;
    }
}
