package com.angfly.anos.ask.app.app_0001_led_demo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.angfly.anos.ask.app.app_0001_led_demo.MainActivity;

public class AutoRunningBroadcast extends BroadcastReceiver{

    private static final String TAG = "AutoRunningBroadcast";

    @Override
    public void onReceive(Context context, Intent intent) {

        // public static final String ACTION_GLOBAL_BUTTON = "android.intent.action.GLOBAL_BUTTON";

        Log.i(TAG, "intent = " + intent);


        Toast.makeText(context, "Get AutoRunningBroadcast open app", Toast.LENGTH_LONG).show();

        Intent intentNewTask = new Intent(context, MainActivity.class);
        intentNewTask.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intentNewTask);
    }
}

