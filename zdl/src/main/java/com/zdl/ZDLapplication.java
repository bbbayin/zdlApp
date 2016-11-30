package com.zdl;

import android.app.Application;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

/**
 * Created by bayin on 2016/11/29.
 */

public class ZDLapplication extends Application {

    public RequestManager mGlidManager;
    public static ZDLapplication APP_INSTANCE;
    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        if (APP_INSTANCE == null)
            APP_INSTANCE = (ZDLapplication) getApplicationContext();
    }

    public  RequestManager getGlidInstance(){
        synchronized (ZDLapplication.class){
            if (mGlidManager == null){
                mGlidManager = Glide.with(ZDLapplication.this);
            }
        }
        return mGlidManager;
    }

}
