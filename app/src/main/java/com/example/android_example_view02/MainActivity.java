package com.example.android_example_view02;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private IntentFilter mIntentFilter;
    private MyConnentBroadCastReceiver mServiceConnection;
    private LocalReceiver mLocalReceiver;
    private Button mDisOrderButton, mOrderButton, mLocalButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //此action 为 获取系统网络状态是否改变
        mServiceConnection = new MyConnentBroadCastReceiver();
        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(mServiceConnection, mIntentFilter);
        initView();
    }

    private void initView() {
        mDisOrderButton = findViewById(R.id.disOrderBtn);
        mOrderButton = findViewById(R.id.OrderBtn);
        mLocalButton = findViewById(R.id.localBtn);
        mDisOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.android_example_view02.DisOrderBroadCast");
                sendBroadcast(intent); //发送无序广播
            }
        });
        mOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.android_example_view02.DisOrderBroadCast");
                sendOrderedBroadcast(intent, null); //发送有序广播
            }
        });
        mLocalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //本地广播 1.获取本地广播实例 2.使用intentFilter 添加 本地广播跳转对象 3.添加接收器 4.注册
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mServiceConnection);
    }


    class MyConnentBroadCastReceiver extends BroadcastReceiver {

        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        public void onReceive(Context context, Intent intent) {

            ConnectivityManager mConnectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isAvailable()) {
                Toast.makeText(context, "available network", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "no available network", Toast.LENGTH_SHORT).show();
            }
        }
    }

    class LocalReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "Receiver the local BroadCast", Toast.LENGTH_SHORT).show();
        }
    }
}
