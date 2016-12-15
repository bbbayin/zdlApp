package com.zdl.iview.base;

import com.zdl.bean.BaseBean;

/**
 * Created by bayin on 2016/11/23.
 */

public interface BaseViewInterface {
    void showProgress();
    void disProgress();
    void netError();
    void updateUI(BaseBean funBean);
    void loadMore(BaseBean funBean);
    void loadMoreFinsh();
    void noMoreLoading();
}
