package com.zdl.factory;


import android.support.v4.app.Fragment;

/**
 * Created by bayin on 2016/11/28.
 */

public class FragmentFactory {
    public static Fragment getFragment(Class<? extends Fragment> fragment) {
        Fragment instance = null;
        try {
            instance = fragment.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        if (instance != null) return instance;
        else throw new RuntimeException("fragment 为 null！");
    }
}
