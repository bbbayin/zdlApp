package com.zdl.ui.fragment;

import com.zdl.R;
import com.zdl.iview.MeInterface;
import com.zdl.presenter.MePresenter;
import com.zdl.ui.base.MvpBaseFragment;

/**
 * Created by bayin on 2016/11/28.
 */

public class MeFragment extends MvpBaseFragment<MeInterface,MePresenter> {

    @Override
    protected MePresenter createPresenter() {
        return new MePresenter();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_me;
    }
}
