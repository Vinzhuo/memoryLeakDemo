package com.lzl.memory;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        StrictMode.setThreadPolicy(new StrictMode
                .ThreadPolicy
                .Builder()
                .detectAll()
                .penaltyLog()
                .build());
        StrictMode.setVmPolicy(new StrictMode
                .VmPolicy
                .Builder()
                .detectActivityLeaks()
                .detectLeakedClosableObjects()
                .detectLeakedSqlLiteObjects()
                .detectLeakedRegistrationObjects()
                .penaltyLog()
                .build());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getFile();
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
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startSecActivity(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    public void start3Activity(View view) {
        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }

    public void start4Activity(View view) {
        Intent intent = new Intent(this, Main4Activity.class);
        startActivity(intent);
    }

    public void start5Activity(View view) {
        Intent intent = new Intent(this, Main5Activity.class);
        startActivity(intent);
    }
    public void start6Activity(View view) {
        Intent intent = new Intent(this, Main6Activity.class);
        startActivity(intent);
    }
}
