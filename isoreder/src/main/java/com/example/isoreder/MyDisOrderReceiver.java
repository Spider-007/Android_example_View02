package com.example.isoreder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyDisOrderReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
//        context.startActivity(new Intent(context,MainActivity.class));
        Toast.makeText(context, "receiver DisOrder Success", Toast.LENGTH_SHORT).show();
    }
}
