package com.zdl.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.zdl.R;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by bayin on 2016/12/1.
 */

public class HomeGridAdapter extends BaseAdapter {
    private String[] mStrings;

    public HomeGridAdapter(String[] data) {
        mStrings = data;
    }

    @Override
    public int getCount() {
        if (mStrings != null)
            return mStrings.length;
        return 0;
    }

    @Override
    public String getItem(int position) {
        return mStrings[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            holder = new Holder();
            convertView = View.inflate(parent.getContext(), R.layout.label_item_layout, null);
            holder.lableText = (TextView) convertView.findViewById(R.id.lable_item_text);
            holder.mImageView = (RoundedImageView) convertView.findViewById(R.id.round_imageview);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        AutoUtils.auto(convertView);
        holder.lableText.setText(mStrings[position]);
        return convertView;
    }

    private class Holder {
        private View rootview;
        private TextView lableText;
        private RoundedImageView mImageView;
    }
}
