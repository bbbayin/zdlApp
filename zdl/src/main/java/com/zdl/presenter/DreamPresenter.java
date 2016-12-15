package com.zdl.presenter;

import android.util.Log;

import com.zdl.bean.DreamResultBean;
import com.zdl.iview.DreamInterface;
import com.zdl.model.DreamModel;

import rx.Subscriber;

/**
 * Created by bayin on 2016/12/5.
 */

public class DreamPresenter extends BasePresenter<DreamInterface> {
    private DreamInterface mIview;
    private DreamModel mDreamModel;
    private final static String TAG = DreamPresenter.class.getSimpleName();

    public DreamPresenter() {
        mDreamModel = new DreamModel();
    }

    public void searchDream(String keyword) {
        if (isAttached()) {
            mIview = getView();
            if (mDreamModel != null) {
                mDreamModel.api_dream(keyword, new Subscriber<DreamResultBean>() {
                    @Override
                    public void onStart() {
                        mIview.hindEmptyView();
                        mIview.showProgress();
                    }

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG,"onError:["+e.toString()+"]");
                    }

                    @Override
                    public void onNext(DreamResultBean dreamResultBean) {
                        if (dreamResultBean.getCode() == 200) {
                            //success
                            mIview.disProgress();
                            try {
                                if (dreamResultBean.getNewslist().size() == 0)
                                    mIview.resultIsEmpty();
                                else {
                                    mIview.hindEmptyView();
                                    mIview.updateUI(dreamResultBean);
                                }
                            } catch (Exception e) {
                                mIview.resultIsEmpty();
                            }

                        } else {
                            //fail
                            mIview.disProgress();
                            mIview.resultIsEmpty();
                        }
                    }
                });
            }
        }
    }


}
