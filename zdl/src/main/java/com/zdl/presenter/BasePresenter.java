package com.zdl.presenter;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by bayin on 2016/11/23.
 */

public abstract class BasePresenter<T> {
    private Reference<T> mTRefeView;
    public void attachView(T view){
        mTRefeView = new WeakReference<T>(view);
    }
    public T getView(){
        return mTRefeView.get();
    }
    public boolean isAttached(){
        return mTRefeView!=null&& mTRefeView.get()!=null;
    }
    public void detachView(){
        if (mTRefeView!=null){
            mTRefeView.clear();
            mTRefeView = null;
        }
    }
}
