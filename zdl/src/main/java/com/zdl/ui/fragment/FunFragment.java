package com.zdl.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.zdl.R;
import com.zdl.adapter.FunAdapter;
import com.zdl.bean.FunBean;
import com.zdl.constant.Constants;
import com.zdl.custormview.AutoToolbar;
import com.zdl.iview.FunIterface;
import com.zdl.presenter.FunPresenter;
import com.zdl.ui.base.ContainerActivity;
import com.zdl.ui.base.MvpBaseFragment;

import butterknife.BindView;

/**
 * Created by bayin on 2016/11/29.
 */

public class FunFragment extends MvpBaseFragment<FunIterface, FunPresenter> implements FunIterface {

    //    @BindView(R.id.loadingview)
//    public ContentLoadingProgressBar mLoadingDrawable;
    @BindView(R.id.fg_baselist_recyclerview)
    RecyclerView mRecyclerView;
    @BindView(R.id.fg_baselist_topimage)
    ImageView mTopImage;
    @BindView(R.id.collapsing)
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    @BindView(R.id.toolbar)
    AutoToolbar mToolbar;

    private int pageNo = 1;
    private int limitPage = 10;
    private FunAdapter mFunAdapter;

    @Override
    protected FunPresenter createPresenter() {
        return new FunPresenter();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_recyclerview;
    }

    @Override
    protected void initView(View inflate, Bundle savedInstanceState) {
        getContainerActivity().getToolbar().setVisibility(View.GONE);
        mCollapsingToolbarLayout.setTitle("娱乐新闻");
        getContainerActivity().setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.mipmap.back);
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.request(pageNo, limitPage);
    }

    @Override
    public void showProgress() {
//        mLoadingDrawable.setVisibility(View.VISIBLE);
//        mLoadingDrawable.show();
    }

    @Override
    public void disProgress() {
//        mLoadingDrawable.hide();
//        mLoadingDrawable.setVisibility(View.GONE);
    }

    @Override
    public void netError() {
        getContentView().setVisibility(View.GONE);
        mBtReload.setVisibility(View.VISIBLE);
    }

    @Override
    public void updateUI(FunBean bean) {
        mFunAdapter = new FunAdapter(bean, getContainerActivity());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mFunAdapter);
    }

    public static void launch(Activity from, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString(Constants.FRAGMENT_TITLE, "娱乐新闻");
        ContainerActivity.launch(from, FunFragment.class, bundle);
    }
}
