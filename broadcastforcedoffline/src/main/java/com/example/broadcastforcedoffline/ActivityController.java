package com.example.broadcastforcedoffline;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityController {

    private List<Activity> mList = new ArrayList<>();

    //add
    public void addActivity(Activity mActivity) {
        if (mList == null) {
            mList = new ArrayList<>();
        } else {
            mList.add(mActivity);
        }
    }

    //remove
    public void removeActivity(Activity mActivity) {
        if (mList == null) {
            mList = new ArrayList<>();
        } else {
            mList.remove(mActivity);
        }
    }

    //finishAll
    public void finishAllActivity() {
        if (mList == null) {
            mList = new ArrayList<>();
        } else {
            for (Activity mActivity :
                    mList) {
                if (mActivity.isFinishing()) {
                    mActivity.finish();
                }
            }
            mList.clear();
        }
    }
}
