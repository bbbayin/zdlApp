package com.zdl.ui;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.widget.ImageView;

import com.zdl.R;
import com.zdl.iview.EnterInterface;
import com.zdl.presenter.EnterPresenter;
import com.zdl.ui.base.MVPBaseActivity;

import butterknife.BindView;

/**
 * Created by bayin on 2016/11/23.
 */

public class EnterActivity extends MVPBaseActivity<EnterInterface,EnterPresenter> implements EnterInterface {
    @BindView(R.id.enter_image)
    ImageView mImageView;

    @Override
    public void startAnimation() {
        ObjectAnimator xA = ObjectAnimator.ofFloat(mImageView, "translationX", 0f, -50f);
        ObjectAnimator yA = ObjectAnimator.ofFloat(mImageView, "translationY", 0f, 50f);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(mImageView, "scaleX", 1f, 1.1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(mImageView, "scaleY", 1f, 1.1f);

        xA.setDuration(3000);
        yA.setDuration(3000);
        scaleX.setDuration(2000);
        scaleY.setDuration(2000);
        AnimatorSet set = new AnimatorSet();
        set.play(scaleX).with(scaleY).before(xA).with(yA);
        set.start();
    }

    @Override
    public void goMainPage() {
        Intent intent = new Intent();
        intent.setClass(EnterActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected EnterPresenter createPresenter() {
        return new EnterPresenter();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_enter;
    }

    @Override
    protected void initView() {
        super.initView();
        mPresenter.excute();
    }
}
