package com.arconsis.gcm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by alexfrank on 24.05.13.
 */
public class CloudMessageReceiver extends BroadcastReceiver {

    private static final String LOG_TAG = CloudMessageReceiver.class.getSimpleName();

    public void onReceive(Context context, Intent intent) {
        Log.i(LOG_TAG, "Receive a message: " + intent);
    }
}
