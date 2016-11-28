package com.zdl.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zdl.presenter.BasePresenter;

import butterknife.ButterKnife;

/**
 * Created by bayin on 2016/11/23.
 */

public abstract class MVPBaseActivity<V,T extends BasePresenter<V>> extends AppCompatActivity {
    protected T mPresenter;
    protected abstract T createPresenter();
    protected abstract int getLayoutID();
    //初始化view
    protected void initView(){}
    //初始化data
    protected void initData(){}
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        ButterKnife.bind(this);
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
        initView();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
