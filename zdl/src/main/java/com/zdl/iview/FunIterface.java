package com.zdl.iview;

import com.zdl.bean.FunBean;

/**
 * Created by bayin on 2016/11/29.
 */

public interface FunIterface {
    void showProgress();
    void disProgress();
    void netError();
    void updateUI(FunBean funBean);
}
