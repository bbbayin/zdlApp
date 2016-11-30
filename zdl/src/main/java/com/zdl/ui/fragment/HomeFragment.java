package com.zdl.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.zdl.R;
import com.zdl.iview.HomeInterface;
import com.zdl.presenter.HomeFgPresenter;
import com.zdl.ui.base.MvpBaseFragment;

import butterknife.OnClick;

/**
 * Created by bayin on 2016/11/28.
 */

public class HomeFragment extends MvpBaseFragment<HomeInterface,HomeFgPresenter> {
    @OnClick(R.id.homefg_bt_enjoy)
    void seeEnjoy(){
        FunFragment.launch(getActivity(),new Bundle());
    }
    @OnClick(R.id.homefg_bt_boring)
    void boring(){
        //todo 无聊
    }
    @OnClick(R.id.homefg_bt_study)
    void study(){
        //todo 学习
    }
    @OnClick(R.id.homefg_bt_cooking)
    void cooking(){
        //todo 晚餐
    }
    @OnClick(R.id.homefg_bt_weichat)
    void wechat(){
        //todo 微信精选
    }
    @OnClick(R.id.homefg_bt_travel)
    void travel(){
        //todo 旅游
    }
    @OnClick(R.id.homefg_bt_countrynews)
    void newsCountry(){
        //todo 国家新闻
    }
    @OnClick(R.id.homefg_bt_healthy)
    void healthy(){
        //todo 健康信息
    }
    @OnClick(R.id.homefg_bt_today)
    void todayOccour(){
        //todo 历史的今天
    }
    @OnClick(R.id.homefg_bt_dream)
    void dream(){
        Bundle bundle = new Bundle();
        // TODO: 2016/11/28
    }
    @Override
    protected HomeFgPresenter createPresenter() {
        return new HomeFgPresenter();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View inflate, Bundle savedInstanceState) {

    }
}
