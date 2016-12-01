package com.zdl.presenter;

import com.zdl.iview.BrowserInterface;

/**
 * Created by bayin on 2016/11/30.
 */

public class BrowserPresenter extends BasePresenter<BrowserInterface> {
    private BrowserInterface mIview;
    public BrowserPresenter() {

    }

    public void loadData(){
        if (isAttached()){
            mIview = getView();
            mIview.loadHtml();
        }
    }
}
