package com.zdl.adapter;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zdl.R;
import com.zdl.bean.FunBean;
import com.zdl.constant.Constants;
import com.zdl.ui.fragment.function.BrowserFragment;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by bayin on 2016/11/30.
 *
 * 娱乐新问
 */

public class FunAdapter extends RecyclerView.Adapter<FunAdapter.FunHolder> implements View.OnClickListener {
    private FunBean mFunBean;
    private List<FunBean.NewslistBean> mNewsList;
    private Activity mContext;
    public FunAdapter(FunBean bean,Activity context) {
        this.mFunBean = bean;
        if (mFunBean !=null){
            mNewsList = mFunBean.getNewslist();
        }
        mContext = context;
    }

    @Override
    public FunHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.item_enjoynews_layout, null);
        return new FunHolder(inflate);
    }

    @Override
    public void onBindViewHolder(FunHolder holder, int position) {
        FunBean.NewslistBean bean = mNewsList.get(position);
        holder.tvSource.setText(bean.getDescription());
        holder.tvTime.setText(bean.getCtime());
        holder.tvTitle.setText(bean.getTitle());
        Glide.with(mContext).load(bean.getPicUrl())
                .crossFade()
                .into(holder.ivPic);
        holder.rootView.setOnClickListener(this);
        holder.rootView.setTag(position);
    }

    @Override
    public int getItemCount() {
        if (mNewsList!=null) return mNewsList.size();
        return 0;
    }

    @Override
    public void onClick(View v) {
        int index = (int) v.getTag();
        Toast.makeText(mContext,""+index,Toast.LENGTH_SHORT).show();
        FunBean.NewslistBean bean = mNewsList.get(index);
        Bundle bundle = new Bundle();
        bundle.putString(BrowserFragment.URL_KEY,bean.getUrl());
        bundle.putString(Constants.FRAGMENT_TITLE,bean.getTitle());
        BrowserFragment.launch(mContext,bundle);
    }

    public class FunHolder extends RecyclerView.ViewHolder{
        private View rootView;
        private TextView tvTitle, tvSource, tvTime;
        private ImageView ivPic;

        public FunHolder(View itemView) {
            super(itemView);
            AutoUtils.auto(itemView);
            rootView = itemView;
            tvTitle = (TextView) itemView.findViewById(R.id.item_enjoy_tv_title);
            tvSource = (TextView) itemView.findViewById(R.id.item_enjoy_tv_source);
            tvTime = (TextView) itemView.findViewById(R.id.item_enjoy_tv_time);
            ivPic = (ImageView) itemView.findViewById(R.id.item_enjoy_iv_pic);
        }
    }
}
