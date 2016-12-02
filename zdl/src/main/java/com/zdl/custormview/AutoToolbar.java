package com.zdl.custormview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.ViewGroup;

import com.zhy.autolayout.AutoLayoutInfo;
import com.zhy.autolayout.utils.AutoLayoutHelper;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by guoshuaijie on 2016/7/26.
 * 自定义toolbar高度   80px
 */
public class AutoToolbar extends Toolbar {
    private final AutoLayoutHelper mHelper = new AutoLayoutHelper(this);
    public AutoToolbar(Context context) {
        super(context);
    }

    public AutoToolbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AutoToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!this.isInEditMode()) {
            this.mHelper.adjustChildren();
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        if(params!=null){
            setMinimumHeight(AutoUtils.getPercentHeightSize(80));
            params.height= AutoUtils.getPercentHeightSize(80);
        }
        super.setLayoutParams(params);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(this.getContext(), attrs);
    }
    public static class LayoutParams extends Toolbar.LayoutParams implements AutoLayoutHelper.AutoLayoutParams {
        private AutoLayoutInfo mDimenLayoutInfo;

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            this.mDimenLayoutInfo = AutoLayoutHelper.getAutoLayoutInfo(c, attrs);
        }

        @Override
        public AutoLayoutInfo getAutoLayoutInfo() {
            return this.mDimenLayoutInfo;
        }

        public LayoutParams(int width, int height) {
            super(width, height);
        }

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
        }

        public LayoutParams(MarginLayoutParams source) {
            super(source);
        }
    }

}
