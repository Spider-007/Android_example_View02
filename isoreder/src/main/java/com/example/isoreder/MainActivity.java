package com.example.isoreder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mOrderButton, mDisButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mOrderButton = findViewById(R.id.btn_SendOrder);
        mDisButton = findViewById(R.id.btn_SendDisOrder);
        mOrderButton.setOnClickListener(this);
        mDisButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_SendDisOrder:
                sendBroadcast(new Intent("com.example.isoreder.MyDisOrderReceiver"));
                break;
            case R.id.btn_SendOrder:
                Intent intent = new Intent("com.example.android_example_view02.DisOrderBroadCast");
                sendOrderedBroadcast(intent, null); //发送有序广播 第二个参数对权限进行处理
                break;
            default:
                break;

        }
    }
}
