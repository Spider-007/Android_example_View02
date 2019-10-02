package com.example.broadcastforcedoffline;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    Activity mActivity = this;
    private IntentFilter mIntentFilter;
    private ForceLineReceiver mForceLineReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new ActivityController().addActivity(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mActivity != null) {
            new ActivityController().removeActivity(mActivity);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mForceLineReceiver = new ForceLineReceiver();
        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction("android.activity.example.FORCE_LINE");
        registerReceiver(mForceLineReceiver, mIntentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mForceLineReceiver != null) {
            unregisterReceiver(mForceLineReceiver);
            mForceLineReceiver = null;
        }
    }

    class ForceLineReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(final Context context, Intent intent) {
            final AlertDialog.Builder mAlertDialog = new AlertDialog.Builder(context);
            mAlertDialog.setTitle("warning!").setMessage("This will close all Activity!Whether to continue？")
                    .setCancelable(false)
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            return;
                        }
                    }).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    new ActivityController().finishAllActivity();
                    startActivity(new Intent(context, LoginActivity.class));
                }
            });
            mAlertDialog.show();
        }
    }
}
