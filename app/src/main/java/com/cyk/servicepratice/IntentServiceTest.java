package com.cyk.servicepratice;

import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;

public class IntentServiceTest extends JobIntentService {
    private static final String TAG = "IntentServiceTest";

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        Log.d(TAG,"Thread id is " + Thread.currentThread().getId());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy executed");
    }
}
