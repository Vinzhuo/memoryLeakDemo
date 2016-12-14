package com.lzl.memory;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Main2Activity extends AppCompatActivity {


    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getFile();


//        ExampleSingleInstance.get().setActivityManager((ActivityManager) this.getSystemService(ACTIVITY_SERVICE));
        ExampleSingleInstance.get().setActivityManager((ActivityManager) this.getApplicationContext().getSystemService(ACTIVITY_SERVICE));

    }
    private void getFile() {
        File externalStorage = Environment.getExternalStorageDirectory();
        File destFile = new File(externalStorage, "dest.txt");

        try {
            if (!destFile.exists()) {
                destFile.createNewFile();
            }
            OutputStream output = new FileOutputStream(destFile, true);
            int i = 0;
            while (i++ < 1000) {
                output.write("erqwerwerweqrwerqwrwqrwqrwerwqerwerweqrewqrweqrwerqrewqrwqqdroidyue.com".getBytes());

            }
            output.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

