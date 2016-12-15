package com.zdl.presenter;

import android.util.Log;

import com.zdl.bean.FunBean;
import com.zdl.constant.Constants;
import com.zdl.iview.FunIterface;
import com.zdl.model.BaseListModel;

import rx.Observer;

/**
 * Created by bayin on 2016/12/6.
 */

public class BaseListPresenter extends BasePresenter<FunIterface> {
    private FunIterface mIview;
    private BaseListModel mModel;

    public BaseListPresenter(String url) {
        mModel = new BaseListModel(url);
    }

    public void requestData(int pageNo, int limit,final int state) {
        if (isAttached()) {
            mIview = getView();
            if (mModel != null) {
                //start
                mIview.showProgress();
                mModel.api_CommonRequest(pageNo, limit, new Observer<FunBean>() {
                    @Override
                    public void onNext(FunBean funBean) {
                        Log.d("xxx", funBean.getMsg());
                        if (funBean.getCode() == 200) {
                            //success
                            if (state == Constants.REFRESH_STATE)
                                mIview.updateUI(funBean);
                            else if (state == Constants.LOADMORE_STATE)
                                mIview.loadMore(funBean);
                        } else {
                            //fail
                            mIview.disProgress();
                            mIview.netError();
                        }
                    }

                    @Override
                    public void onCompleted() {
                        mIview.disProgress();
                        if (state == Constants.LOADMORE_STATE)
                            mIview.loadMoreFinsh();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("xxx", e.toString());
                        mIview.loadMoreFinsh();
                        mIview.netError();
                    }
                });
            }
        }

    }

}
