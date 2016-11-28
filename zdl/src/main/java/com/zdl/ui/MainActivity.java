package com.zdl.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioGroup;

import com.zdl.R;
import com.zdl.factory.FragmentFactory;
import com.zdl.ui.fragment.HomeFragment;
import com.zdl.ui.fragment.MeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    @BindView(R.id.main_viewpager)
    ViewPager mViewPager;
    @BindView(R.id.radiogroup)
    RadioGroup mRadioGroup;
    private MyAdapter mMyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        setViewPager();
        mRadioGroup.setOnCheckedChangeListener(this);
    }

    private void setViewPager() {
        mMyAdapter = new MyAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mMyAdapter);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.radio_home:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.radio_me:
                mViewPager.setCurrentItem(1);
                break;
        }
    }

    private class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return FragmentFactory.getFragment(HomeFragment.class);
                case 1:
                    return FragmentFactory.getFragment(MeFragment.class);
            }
            return null;
        }
    }
}
