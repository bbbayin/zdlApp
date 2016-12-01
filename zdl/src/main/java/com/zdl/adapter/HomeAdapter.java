package com.zdl.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.zdl.R;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by bayin on 2016/12/1.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeHolder>  {
    private String[] mStr;
    public HomeAdapter(String[] data) {
        mStr = data;
    }

    @Override
    public HomeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.label_item_layout, null);
        return new HomeHolder(inflate);
    }

    @Override
    public void onBindViewHolder(HomeHolder holder, int position) {
        holder.lableText.setText(mStr[position]);
    }

    @Override
    public int getItemCount() {
        if (mStr!=null) return mStr.length;
        return 0;
    }

    public class HomeHolder extends RecyclerView.ViewHolder{
        private View rootview;
        private TextView lableText;
        private RoundedImageView mImageView;
        public HomeHolder(View itemView) {
            super(itemView);
            AutoUtils.auto(itemView);
            rootview = itemView;
            lableText = (TextView) itemView.findViewById(R.id.lable_item_text);
            mImageView = (RoundedImageView) itemView.findViewById(R.id.round_imageview);
        }
    }
}
