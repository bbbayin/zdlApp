package com.zdl.ui.base;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.zdl.R;
import com.zdl.constant.Constants;
import com.zdl.iview.ContainerInterface;
import com.zdl.presenter.ContainerPresenter;

import java.lang.reflect.Method;

import butterknife.BindView;

import static android.R.attr.fragment;

/**
 * Created by bayin on 2016/11/28.
 */

public class ContainerActivity extends MVPBaseActivity<ContainerInterface, ContainerPresenter> implements ContainerInterface {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_title)
    TextView mTitle;
    @BindView(R.id.fragment_container)
    FrameLayout mContainer;

    private Fragment mFragment;
    private Bundle mArgs;

    @Override
    protected ContainerPresenter createPresenter() {
        return new ContainerPresenter();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_container_layout;
    }

    @Override
    protected void initView() {
        super.initView();
        Intent intent = getIntent();
        if (intent != null) {
            //fragment
            String className = intent.getStringExtra(Constants.FRAGMENT_CLASSNAME);
            if (!TextUtils.isEmpty(className)) {
                try {
                    Class<?> aClass = Class.forName(className);
                    mFragment = (Fragment) aClass.newInstance();
                    mArgs = intent.getBundleExtra(Constants.FRAGMENT_ARGSKEY);
                    if (mArgs != null) {
                        try {
                            Method method = aClass.getMethod("setArguments", new Class[]{Bundle.class});
                            method.invoke(fragment, mArgs);
                        } catch (Exception e) {
                        }
                        //title
                        String title = mArgs.getString(Constants.FRAGMENT_TITLE);
                        if (!TextUtils.isEmpty(title)) mTitle.setText(title);
                        else mTitle.setText("MyAPP Title");
                    }

                    //add fragment
                    getFragmentManager().beginTransaction().add(R.id.fragment_container, mFragment, className)
                            .addToBackStack(className)
                            .commitAllowingStateLoss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else return;
        }
    }

    public static void launch(Activity from, Class<? extends Fragment> claz, Bundle args) {
        Intent intent = new Intent();
        initLunchMode(intent, args);
        intent.setClass(from, ContainerActivity.class);
        if (args != null) {
            intent.putExtra(Constants.FRAGMENT_CLASSNAME, claz.getName());
            intent.putExtra(Constants.FRAGMENT_ARGSKEY, args);
        }
        from.startActivity(intent);
    }


    private static void initLunchMode(Intent intent, Bundle args) {
        int anInt = args.getInt("lunch_mode", -3);
        if (anInt != -3) {
            intent.addFlags(anInt);
        }
    }

    @Override
    public void initTitleBar() {

    }
}
