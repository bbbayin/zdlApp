package com.zdl.model;

import com.zdl.http.RetrofitWrapper;

import retrofit2.Retrofit;

/**
 * Created by bayin on 2016/11/30.
 */

public class BaseModel {
    protected Retrofit mRetrofit;

    public BaseModel() {
        this.mRetrofit = RetrofitWrapper.getRetrofit();
    }
}
