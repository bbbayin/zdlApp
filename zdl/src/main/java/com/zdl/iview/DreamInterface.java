package com.zdl.iview;

import com.zdl.bean.DreamResultBean;

/**
 * Created by bayin on 2016/12/5.
 */

public interface DreamInterface {
    void showProgress();
    void disProgress();
    void updateUI(DreamResultBean dreamResultBean);
    void resultIsEmpty();
    void hindEmptyView();
}
