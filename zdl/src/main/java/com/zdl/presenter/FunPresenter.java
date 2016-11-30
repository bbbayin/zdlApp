package com.zdl.presenter;

import android.os.Handler;
import android.util.Log;

import com.zdl.bean.FunBean;
import com.zdl.iview.FunIterface;
import com.zdl.model.FunModel;

import rx.Observer;

/**
 * Created by bayin on 2016/11/29.
 */

public class FunPresenter extends BasePresenter<FunIterface> {
    private static String TAG = "ZDL result:" + FunPresenter.class.getSimpleName() + "---";
    private FunModel mFunModel;
    private FunIterface mIview;

    public FunPresenter() {
        mFunModel = new FunModel();
    }

    public void request(int page, int num) {
        if (isAttached()) {
            mIview = getView();
            if (mFunModel != null) {
                //start
                mIview.showProgress();

                mFunModel.api_fun(page, num, new Observer<FunBean>() {

                    @Override
                    public void onNext(FunBean funBean) {
                        Log.d("xxx",funBean.getMsg());
                        if (funBean.getCode() == 200){
                            //success
                            mIview.updateUI(funBean);
                        }else {
                            mIview.disProgress();
//                            mIview.netError();
                        }
                    }

                    @Override
                    public void onCompleted() {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mIview.disProgress();
                            }
                        },5000);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("xxx",e.toString());
                    }
                });
            }
        }
    }
}
