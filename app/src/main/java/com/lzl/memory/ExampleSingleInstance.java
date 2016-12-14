package com.lzl.memory;

import android.app.Activity;
import android.app.ActivityManager;

/**
 * Created by liuzhuolin on 2016/12/12.
 */

final public class ExampleSingleInstance {

    private ActivityManager am;
    private Activity activity;

    private ExampleSingleInstance() {

    }
    private interface Holder {
        ExampleSingleInstance sInstance = new ExampleSingleInstance();
    }
    public static ExampleSingleInstance get() {
        return Holder.sInstance;
    }
    public void setActivityManager(ActivityManager manager) {
        this.am = manager;
    }
    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
