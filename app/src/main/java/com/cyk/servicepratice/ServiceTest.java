package com.cyk.servicepratice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class ServiceTest extends Service {
    private static final String TAG = "ServiceTest";
    private DownloadBinder mBinder = new DownloadBinder();
    public ServiceTest() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate executed");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand executed");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy executed");
    }

    /*内部类，练习Binder*/
    class DownloadBinder extends Binder {
        public void startDownload() {
            Log.d(TAG,"startDownload executed");
        }

        public int getProgress() {
            Log.d(TAG,"getProgress executed");
            return 0;
        }

    }
}