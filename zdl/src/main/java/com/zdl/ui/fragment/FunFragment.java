package com.zdl.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.malinskiy.superrecyclerview.OnMoreListener;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
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

public class FunFragment extends MvpBaseFragment<FunIterface, FunPresenter> implements FunIterface, SwipeRefreshLayout.OnRefreshListener, OnMoreListener {

    //    @BindView(R.id.loadingview)
//    public ContentLoadingProgressBar mLoadingDrawable;
    @BindView(R.id.fg_baselist_recyclerview)
    SuperRecyclerView mRecyclerView;
    @BindView(R.id.fg_baselist_topimage)
    ImageView mTopImage;
    @BindView(R.id.collapsing)
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    @BindView(R.id.fg_baselist_toolbar)
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
        getContainerActivity().setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.mipmap.back);
        mCollapsingToolbarLayout.setTitle("娱乐新闻");
        mRecyclerView.setRefreshListener(this);
        mRecyclerView.setOnMoreListener(this);
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.request(pageNo, limitPage,Constants.REFRESH_STATE);
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

    @Override
    public void loadMore(FunBean funBean) {
        mFunAdapter.add(funBean);
    }

    @Override
    public void loadMoreFinsh() {
        mRecyclerView.setLoadingMore(false);
    }

    @Override
    public void noMoreLoading() {

    }

    public static void launch(Activity from, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString(Constants.FRAGMENT_TITLE, "娱乐新闻");
        ContainerActivity.launch(from, FunFragment.class, bundle);
    }

    @Override
    public void onRefresh() {
        pageNo=1;
        mPresenter.request(pageNo,limitPage,Constants.REFRESH_STATE);
    }

    @Override
    public void onMoreAsked(int overallItemsCount, int itemsBeforeMore, int maxLastVisiblePosition) {
        ++pageNo;
        mPresenter.request(pageNo,limitPage,Constants.LOADMORE_STATE);
    }


}
