package com.zdl.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zdl.R;
import com.zdl.bean.DreamResultBean;

import java.util.List;

/**
 * Created by bayin on 2016/12/5.
 */

public class DreamAdapter extends RecyclerView.Adapter<DreamAdapter.DreamHolder> {
    private List<DreamResultBean.NewslistBean> mList;

    public DreamAdapter(DreamResultBean bean) {
        if (bean != null)
            mList = bean.getNewslist();
    }

    @Override
    public DreamHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.item_dream_result, null);
        return new DreamHolder(inflate);
    }

    @Override
    public void onBindViewHolder(DreamHolder holder, int position) {
        DreamResultBean.NewslistBean bean = mList.get(position);
        holder.tvType.setText(bean.getType());
        holder.tvKeyword.setText(bean.getTitle());
        holder.tvResult.setText(bean.getResult());
    }

    @Override
    public int getItemCount() {
        if (mList != null) return mList.size();
        return 0;
    }

    public void refresh(DreamResultBean bean){
        if (bean == null){
            mList = null;
        }else mList = bean.getNewslist();
        notifyDataSetChanged();
    }

    public class DreamHolder extends RecyclerView.ViewHolder {
        private TextView tvType, tvKeyword, tvResult;

        public DreamHolder(View itemView) {
            super(itemView);
            tvType = (TextView) itemView.findViewById(R.id.item_dream_tv_type);
            tvKeyword = (TextView) itemView.findViewById(R.id.item_dream_tv_things);
            tvResult = (TextView) itemView.findViewById(R.id.item_dream_tv_result);
        }
    }
}
