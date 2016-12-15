package com.zdl.ui.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.zdl.R;
import com.zdl.adapter.GridItemDivide;
import com.zdl.adapter.HomeAdapter;
import com.zdl.bean.HomeLableBean;
import com.zdl.custormview.GridRecyclerView;
import com.zdl.iview.HomeInterface;
import com.zdl.presenter.HomeFgPresenter;
import com.zdl.ui.base.MvpBaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by bayin on 2016/11/28.
 */

public class HomeFragment extends MvpBaseFragment<HomeInterface, HomeFgPresenter> {
    //    @OnClick(R.id.homefg_bt_enjoy)
//    void seeEnjoy(){
//        FunFragment.launch(getActivity(),new Bundle());
//    }
//    @OnClick(R.id.homefg_bt_boring)
//    void boring(){
//        //todo 无聊
//    }
//    @OnClick(R.id.homefg_bt_study)
//    void study(){
//        //todo 学习
//    }
//    @OnClick(R.id.homefg_bt_cooking)
//    void cooking(){
//        //todo 晚餐
//    }
//    @OnClick(R.id.homefg_bt_weichat)
//    void wechat(){
//        //todo 微信精选
//    }
//    @OnClick(R.id.homefg_bt_travel)
//    void travel(){
//        //todo 旅游
//    }
//    @OnClick(R.id.homefg_bt_countrynews)
//    void newsCountry(){
//        //todo 国家新闻
//    }
//    @OnClick(R.id.homefg_bt_healthy)
//    void healthy(){
//        //todo 健康信息
//    }
//    @OnClick(R.id.homefg_bt_today)
//    void todayOccour(){
//        //todo 历史的今天
//    }
//    @OnClick(R.id.homefg_bt_dream)
//    void dream(){
//        Bundle bundle = new Bundle();
//        // TODO: 2016/11/28
//    }
    @BindView(R.id.home_recyclerview)
    GridRecyclerView mGridView;
    private String[] mLableString;

    private int[] mArrImageSource =
            {R.drawable.lable_fun,
            R.drawable.lable_dream,
            R.drawable.lable_boring,
            R.drawable.lable_study,
            R.drawable.lable_food,
            R.drawable.lable_jingxuan,
            R.drawable.lable_travel,
            R.drawable.lable_country,
            R.drawable.lable_sport,
            R.drawable.lable_history};

    private String[] fragmentName =
            {FunFragment.class.getSimpleName(),
                    ReadDreamFragment.class.getSimpleName(),
                    StrangeFragment.class.getSimpleName(),
                    "", "", "", "", "", "", ""};

    private List<HomeLableBean> mList;

    @Override
    protected HomeFgPresenter createPresenter() {
        return new HomeFgPresenter();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_home_lable_layout;
    }

    @Override
    protected void initData() {
        HomeLableBean lableBena;
        if (mList == null) mList = new ArrayList<>();
        mLableString = getActivity().getResources().getStringArray(R.array.lable_titles);
        for (int i = 0; i < mLableString.length; i++) {
            lableBena = new HomeLableBean();
            lableBena.setLableTitle(mLableString[i]);
            lableBena.setResId(mArrImageSource[i]);
            lableBena.setFragmentName(fragmentName[i]);
            mList.add(lableBena);
        }
        //setadapter
//        HomeGridAdapter adapter = new HomeGridAdapter(mLableString);
        HomeAdapter homeAdapter = new HomeAdapter(getActivity(), mList);
        mGridView.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false));
        Drawable divide = getActivity().getResources().getDrawable(R.drawable.shape_divider_transparent);
        mGridView.addItemDecoration(new GridItemDivide(getActivity(), divide));
        mGridView.setAdapter(homeAdapter);
    }

    @Override
    protected void initView(View inflate, Bundle savedInstanceState) {

    }
}
