package com.zdl.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.zdl.R;
import com.zdl.adapter.DreamAdapter;
import com.zdl.bean.DreamResultBean;
import com.zdl.iview.DreamInterface;
import com.zdl.presenter.DreamPresenter;
import com.zdl.ui.base.ContainerActivity;
import com.zdl.ui.base.MvpBaseFragment;

import net.yslibrary.android.keyboardvisibilityevent.util.UIUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by bayin on 2016/12/5.
 */

public class ReadDreamFragment extends MvpBaseFragment<DreamInterface, DreamPresenter> implements DreamInterface {

    private DreamAdapter mDreamAdapter;

    @OnClick(R.id.read_dream_bt_search)
    void search() {
        String keyword = mEtKeyword.getText().toString();
        if (TextUtils.isEmpty(keyword)) {
            Toast.makeText(getActivity(), "你不输东西咋查??\n逗..", Toast.LENGTH_SHORT).show();
        } else {
            mPresenter.searchDream(keyword);
            UIUtil.hideKeyboard(getActivity());
        }
    }

    @BindView(R.id.read_dream_et_keyword)
    EditText mEtKeyword;
    @BindView(R.id.read_dream_recyclerview)
    RecyclerView mRecyclerView;
    @BindView(R.id.read_dream_progress)
    ProgressBar mProgressBar;
    @BindView(R.id.read_dream_tv_resultnull)
    TextView mTvResultNull;

    @Override
    protected DreamPresenter createPresenter() {
        return new DreamPresenter();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_read_dream;
    }

    @Override
    protected void initView(View inflate, Bundle savedInstanceState) {
        getContainerActivity().getToolbar().setVisibility(View.GONE);
        UIUtil.showKeyboard(getActivity(), null);

    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void disProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void updateUI(DreamResultBean dreamResultBean) {
        mDreamAdapter = new DreamAdapter(dreamResultBean);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mDreamAdapter);
    }

    @Override
    public void resultIsEmpty() {
        mDreamAdapter.refresh(null);
        mTvResultNull.setVisibility(View.VISIBLE);
    }

    @Override
    public void hindEmptyView() {
        mTvResultNull.setVisibility(View.GONE);
    }

    public static void launch(Activity from){
        ContainerActivity.launch(from,ReadDreamFragment.class,new Bundle());
    }
}
