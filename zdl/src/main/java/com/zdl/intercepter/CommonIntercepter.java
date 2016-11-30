package com.zdl.intercepter;

import android.util.Log;

import com.zdl.constant.Constants;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by bayin on 2016/11/30.
 */

public class CommonIntercepter implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request oldRequest = chain.request();
        HttpUrl.Builder builder = oldRequest.url()
                .newBuilder()
                .scheme(oldRequest.url().scheme())
                .addQueryParameter("key", Constants.HTTP_KEY);
        Request newRequest = oldRequest.newBuilder().method(oldRequest.method(), oldRequest.body())
                .url(builder.build())
                .build();
        Log.d("ZDL-APP[http result", "\nMethod:" + newRequest.method() + "\n"
                + "URL:" + newRequest.url() + "\n"
                + "HTTPS:" + newRequest.isHttps() + "]");
        return chain.proceed(newRequest);
    }
}
