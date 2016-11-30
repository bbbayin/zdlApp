package com.zdl.http;


import com.zdl.intercepter.CommonIntercepter;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bayin on 2016/8/11.
 */
public class RetrofitWrapper {
    private static Retrofit retrofit;
    private RetrofitWrapper(){}

    public static Retrofit getRetrofit(){
        if (retrofit == null){
            synchronized (RetrofitWrapper.class){
                OkHttpClient client = new OkHttpClient.Builder()
                        .addInterceptor(new CommonIntercepter())
                        .build();
                retrofit = new Retrofit.Builder()
                        .baseUrl(Urls.baseUrl)
                        .client(client)
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
        }
        return retrofit;
    }
}
