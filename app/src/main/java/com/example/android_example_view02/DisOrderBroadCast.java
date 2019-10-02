package com.example.android_example_view02;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class DisOrderBroadCast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Log.e("SpiderLine", "onReceive: 接收到无序广播");
        Toast.makeText(context, "Receiver Disorder BroadCast", Toast.LENGTH_LONG).show();
        abortBroadcast();
    }
}
