package com.example.android_example_view02;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBootCompletedReceiver extends BroadcastReceiver {

    //系统开机启动完成会走该方法！
    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    @Override
    public void onReceive(Context context, Intent intent) {
        // 可以打出log 来，系统开机后 会走到！
        Toast.makeText(context, "Receive The BroadCastReceiver", Toast.LENGTH_SHORT).show();
    }
}
