package com.zdl.ui.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.zdl.R;
import com.zdl.presenter.BasePresenter;

import butterknife.ButterKnife;

/**
 * Created by bayin on 2016/11/23.
 */

public abstract class MvpBaseFragment<V,T extends BasePresenter<V>> extends Fragment {
    public T mPresenter;
    private View mRootView;
    private FrameLayout mLayoutContainer;
    private View mInflate;
    public Button mBtReload;

    protected abstract T createPresenter();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preInit();
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
    }

    /**
     * 在oncreate()执行时调用
     */
    protected void preInit(){}

    protected abstract int getLayoutID();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //根布局
        mRootView = inflater.inflate(R.layout.fragment_base_layout,container,false);
        //子类容器
        mLayoutContainer = (FrameLayout) mRootView.findViewById(R.id.base_fg_container);
        mBtReload = (Button) mRootView.findViewById(R.id.base_fg_bt_reload);
        mBtReload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initData();
            }
        });
        //子类的layout

        mInflate = View.inflate(getActivity(), getLayoutID(), null);
        mLayoutContainer.addView(mInflate);
        ButterKnife.bind(this, mInflate);
        initView(mInflate,savedInstanceState);
        initData();
        return mRootView;
    }

    protected View getContentView(){
        return mInflate;
    }

    protected void initData() {

    }

    protected abstract void initView(View inflate, Bundle savedInstanceState);

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    protected ContainerActivity getContainerActivity(){
        return (ContainerActivity) getActivity();
    }
}
