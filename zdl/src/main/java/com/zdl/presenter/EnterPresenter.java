package com.zdl.presenter;

import android.os.Handler;
import android.os.Message;

import com.zdl.iview.EnterInterface;

/**
 * Created by bayin on 2016/11/23.
 */

public class EnterPresenter extends BasePresenter<EnterInterface> {

    private EnterInterface mView;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mView.goMainPage();
        }
    };
    public void excute(){
        if (isAttached()){
            mView = getView();
            mView.startAnimation();
            mHandler.sendEmptyMessageDelayed(1,4000);
        }
    }
}
