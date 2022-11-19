package com.cyk.servicepratice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.JobIntentService;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {
    private ServiceTest.DownloadBinder downloadBinder;
    private static final String TAG = "ServiceActivity";

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downloadBinder = (ServiceTest.DownloadBinder) service;
            downloadBinder.startDownload();
            downloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        Button start = findViewById(R.id.startService);
        Button stop = findViewById(R.id.stopService);
        Button bind = findViewById(R.id.bindService);
        Button unbind = findViewById(R.id.UnbindService);
        Button startForegroundService = findViewById(R.id.startForegroundService);
        Button stopForegroundService = findViewById(R.id.stopForegroundService);
        Button startJobIntent = findViewById(R.id.startJobIntentService);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);
        bind.setOnClickListener(this);
        unbind.setOnClickListener(this);
        startJobIntent.setOnClickListener(this);
        startForegroundService.setOnClickListener(this);
        stopForegroundService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.startService:
                Intent startIntent = new Intent(this, ServiceTest.class);
                startService(startIntent);
                break;
            case R.id.stopService:
                Intent stopIntent = new Intent(this, ServiceTest.class);
                stopService(stopIntent);
                break;
            case R.id.bindService:
                Intent bindIntent = new Intent(this, ServiceTest.class);
                bindService(bindIntent, connection, BIND_AUTO_CREATE);
                break;
            case R.id.UnbindService:
                unbindService(connection);
                break;
            case R.id.startForegroundService:
                Intent startForegroundIntent = new Intent(this, ForegroundService.class);
                startService(startForegroundIntent);
                break;
            case R.id.stopForegroundService:
                Intent stopForegroundIntent = new Intent(this, ForegroundService.class);
                stopService(stopForegroundIntent);
            case R.id.startJobIntentService:
                Log.d(TAG, "Main thread id is " + Thread.currentThread().getId());
                Intent jobIntent = new Intent(this, IntentServiceTest.class);
                startService(jobIntent);
                break;
            default:
                break;
        }
    }
}