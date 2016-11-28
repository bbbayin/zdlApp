package com.zdl.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zdl.presenter.BasePresenter;

/**
 * Created by bayin on 2016/11/23.
 */

public abstract class MvpBaseFragment<V,T extends BasePresenter<V>> extends Fragment {
    private T mPresenter;
    private View mRootView;
    protected abstract T createPresenter();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
    }

    protected abstract int getLayoutID();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutID(),container,false);

        return mRootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
