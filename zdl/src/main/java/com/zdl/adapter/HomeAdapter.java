package com.zdl.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.makeramen.roundedimageview.RoundedImageView;
import com.zdl.R;
import com.zdl.bean.HomeLableBean;
import com.zdl.ui.fragment.FunFragment;
import com.zdl.util.ImageUtil;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by bayin on 2016/12/1.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeHolder> implements View.OnClickListener {
//    private String[] mStr;
//    private int[] mImages;
    private Activity mContext;
    private List<HomeLableBean> mDataList;

    public HomeAdapter(Activity contexts, List<HomeLableBean> list) {
        mContext = contexts;
        mDataList = list;
    }

    @Override
    public HomeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.label_item_layout, null);
        return new HomeHolder(inflate);
    }

    @Override
    public void onBindViewHolder(HomeHolder holder, int position) {
        HomeLableBean lableBean = mDataList.get(position);
        holder.lableText.setText(lableBean.getLableTitle());
        Bitmap okBitmap = getBitmap(lableBean.getResId(),lableBean.getLableTitle());
        holder.mImageView.setImageBitmap(okBitmap);

        //click
        holder.rootview.setTag(lableBean);
        holder.rootview.setOnClickListener(this);
    }

    private Bitmap getBitmap(int image, String key) {
        Bitmap bitmap = null;
        if (ImageUtil.get(mContext, key) == null) {
            BitmapFactory.Options opt = new BitmapFactory.Options();
            opt.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(mContext.getResources(), image, opt);
            opt.inSampleSize = calculateInSampleSize(opt, 200, 380);
            opt.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeResource(mContext.getResources(), image, opt);
            ImageUtil.cacheImage(mContext, key, bitmap);
        } else {
            bitmap = ImageUtil.get(mContext, key);
        }
        return bitmap;
    }

    public int calculateInSampleSize(BitmapFactory.Options options,
                                     int reqWidth, int reqHeight) {
        // 源图片的高度和宽度
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            // 计算出实际宽高和目标宽高的比率
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);
            // 选择宽和高中最小的比率作为inSampleSize的值，这样可以保证最终图片的宽和高
            // 一定都会大于等于目标的宽和高。
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        return inSampleSize;
    }

    @Override
    public int getItemCount() {
        if (mDataList != null) return mDataList.size();
        return 0;
    }

    @Override
    public void onClick(View v) {
        HomeLableBean bena = (HomeLableBean) v.getTag();
        if (bena!=null){
            String fragmentName = bena.getFragmentName();
            if (TextUtils.isEmpty(fragmentName)){
                Toast.makeText(mContext,"/(ㄒoㄒ)/~~等等吧..",Toast.LENGTH_SHORT).show();
            }else {
                if (fragmentName.equals("FunFragment")) FunFragment.launch(mContext,null);
            }

        }
    }

    public class HomeHolder extends RecyclerView.ViewHolder {
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
